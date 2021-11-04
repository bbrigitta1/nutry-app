

/registration //SPRING HAS SOLUTION POST 
userName: string, 
email: string,
password 

/login, //SPRING HAS SOLUTION 

/logout //SPRING HAS SOLUTION

/user-data/{id} 
GET 
id: int, 
// hashed-password: string, 
email: string, 
name: string 
age: int 
weight: int, 
height: int, 
activity: string/int, 
goal: string/int, 

POST 
id: int, 
// hashed-password: string, 
//email: string, 
//name: string,
age: int 
weight: int, 
height: int, 
activity: string/int, 
goal: string/int,

/foods/{?foodName} //search 
GET 
foodId: {generated}, 
foodDescription: string, 
foodCategory: string, ...

/nutrients/{foodId} 
GET 
foodId: nurientId: {generated} 
value: int

/food-consumed/{userId}/{dateFrom}/{dateTo} 
GET 
date: date, 
foodDescription: 
nutrients: 
amount: 
badge: 
marker:

/food-consumed/{foodId}/{userId}/{consumedAmount} //date added by sql //used for add food, and change amount 
POST 
foodId: 
userId: 
consumedAmount:

/favourite/{foodId} GET





"Energy",
"Protein",
"Total lipid (fat)",
"Carbohydrate, by difference",
"Sugars, total including NLEA",
"Fiber, total dietary",
"Calcium, Ca",
"Iron, Fe",
"Magnesium, Mg",
"Phosphorus, P",
"Potassium, K",
"Sodium, Na",
"Zinc, Zn",
"Copper, Cu",
"Selenium, Se",
"Retinol",
"Vitamin A, RAE",
"Carotene, beta",
"Carotene, alpha",
"Vitamin E (alpha-tocopherol)",
"Vitamin D (D2 + D3)",
"Cryptoxanthin, beta",
"Lycopene",
"Lutein + zeaxanthin",
"Vitamin C, total ascorbic acid",
"Thiamin",
"Riboflavin",
"Niacin",
"Vitamin B-6",
"Folate, total",
"Vitamin B-12",
"Choline, total",
"Vitamin K (phylloquinone",
"Folic acid",
"Folate, food",
"Folate, DFE",
"Vitamin E, added",
"Vitamine B12, added",
"Cholesterol",
"Fatty acids, total saturated",
"Fatty acids, total monounsaturated",
"Fatty acids, total polyunsaturated",


public Map<Nutrient, Double> getAvgMacronutrientsForPeriod(@RequestBody EnergyPeriodDTO periodDTO) {
        User user = userService.findById(1L);

        LocalDate end = LocalDate.now().plusDays(1);
        LocalDate start = end.minusDays(periodDTO.getPeriod());

        List<LocalDate> dateList = start.datesUntil(end)
                .collect(Collectors.toList());

        Double nrOfDays = 0.0;

        Map<Nutrient, Double> nutrientConsumption = new HashMap<>();

        for (LocalDate dat : dateList) {
            List<FoodConsumed> foodsConsumedByUser = foodConsumedService.findFoodConsumedsByUserAndConsumptionDate(user, dat);
            if (!foodsConsumedByUser.isEmpty()) {
                nrOfDays += 1.0;
                for (FoodConsumed foodConsumed : foodsConsumedByUser ) {
                    for (FoodNutrient foodNutrient : foodConsumed.getFood().getFoodNutrients()) {
                        Nutrient actualFoodNutrient = foodNutrient.getNutrient();
                        if (nutrientConsumption.containsKey(actualFoodNutrient)) {
                            Double oldValue = nutrientConsumption.get(foodNutrient.getNutrient());
                            Double newValue = foodNutrient.getValue() * foodConsumed.getAmount() / 100;
                            nutrientConsumption.put(actualFoodNutrient, oldValue + newValue);
                        } else {
                            nutrientConsumption.put(actualFoodNutrient, 0.0);
                        }
                    }
                }
            }
        }

        for (Map.Entry<Nutrient, Double> entry : nutrientConsumption.entrySet()) {
           Nutrient key = entry.getKey();
           Double value = entry.getValue();
           nutrientConsumption.put(key, value/nrOfDays);
        }
        System.out.println(nutrientConsumption.toString());;
        return nutrientConsumption;
    }