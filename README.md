# Descrpition du projet : WishMeGift

## BASE DE DONNEES

### Conception du MCD

![MCD](./readme_assets/images/MCD.png)

### Conception du MLD

![MLD](./readme_assets/images/MLD.png)

## USER STORIES

| ID | En tant que | Action | Afin de |
| -- | ----------- | ------ | ------- |
| US01 | Utilisateur connecté | créer une liste de souhaits | décrire ce que je veux |
| US02 | Utilisateur qui à créer une liste | ajouter des cadeaux de la liste | compléter ma liste |
| US03 | Auteur | administrer une liste | ajouter modifier ou d'enlever une ou plusieurs liste |
| US04 | Auteur | administrer les cadeaux | ajouter modifier ou d'enlever un ou plusieurs cadeaux dans une liste |
| US05 | Utilisateur | créer un compte (simulation) | pour pouvoir se connecter |
| US06 | Utilisateur | se connecter(simulation) | afin de créer ou consulter une listes |
| US07 | Utilisateur connecté | partager une liste de souhaits | pouvoir partager mes souhaits |
| US08 | Utilisateur connecté | voir les listes de souhaits partagées | consulter les différentes listes qui lui ont été partagées |
| US09 | Utilisateur connecté | réserver un cadeau d'une liste | |

```plantuml
@startuml
!theme amiga
left to right direction

together {
  actor :user: as USR
  actor :invited: as INVUSR
  actor :connected user: as CUSR
  actor :author: as AUT
}

rectangle "WishMeGift" {
  "Login" as (User1)
  "Register" as (User2)
  
  "Create wishlist" as (CUser1)
  "See shared wishlists" as (CUser2)
  
  "Reserve a gift (from other list)" as (INVUSR1)
  
  "Add a gift from his wishlists" as (AUT1)
  "Remove gift from his wishlists" as (AUT2)
  "Share his wishlists" as (AUT3)
}

AUT -|> CUSR
CUSR <|- INVUSR

USR --> (User1)
USR --> (User2)

CUSR --> (CUser1)
CUSR --> (CUser2)
INVUSR --> (INVUSR1)

AUT --> (AUT1)
AUT --> (AUT2)
AUT --> (AUT3)

@enduml
```