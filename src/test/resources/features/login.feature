@Login

Feature: as user starsharp page
  I want login with my credentials
  To create a product

Scenario: validate login succesful
Given The user "admin" enters into the page
When The user enter credentials into the fields
  | admin | serenity |
Then The user should see the title "Tablero"