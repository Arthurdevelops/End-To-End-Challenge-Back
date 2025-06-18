# End-To-End-Challenge-Back

Ce projet est une application Spring Boot qui fournit une API RESTful pour la gestion des utilisateurs.

## Technologies utilisées

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- Base de données H2 (en mémoire)
- Maven

## Fonctionnalités

- Création d'utilisateurs
- Récupération de la liste des utilisateurs
- Stockage des données dans une base H2 en mémoire

## Structure du projet

Le projet suit une architecture standard Spring Boot :

- `UserController` : Gère les endpoints REST
- `UserService` : Contient la logique métier
- `UserRepository` : Interface pour l'accès aux données
- `User` : Entité JPA représentant un utilisateur

## Configuration

La base de données H2 est configurée avec les paramètres suivants :

- URL : jdbc:h2:mem:testdb
- Username : sa
- Password : (vide)
- Console H2 : activée (accessible via /h2-console)

## Endpoints API

### GET /users

Récupère la liste de tous les utilisateurs.

### POST /users

Crée un nouvel utilisateur.

Exemple de body :

```json
{
  "username": "exemple",
  "email": "exemple@email.com"
}
```

## Démarrage

1. Cloner le projet
2. Exécuter : `./mvnw spring-boot:run`
3. L'application sera accessible sur `http://localhost:8080`

## Développement

Pour construire le projet :

```bash
./mvnw clean install
```
