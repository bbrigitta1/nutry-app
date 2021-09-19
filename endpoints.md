

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
