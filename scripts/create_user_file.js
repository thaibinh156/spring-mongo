use user_database;

db.users.insertOne({
    id: 1,
    name : 'Diep Thai Binh',
    sex: "MALE",
    created_date: new Date(),
    updated_date: new Date(),
    password: "123123123"
})