SELECT Firstname,
       Lastname,
       City,
       State
FROM   Person
       LEFT JOIN Address
              ON Person.Personid = Address.Personid