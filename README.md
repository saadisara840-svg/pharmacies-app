# 💊 Pharmacies de Garde - Android Secure App

## 📱 Description
Application Android permettant de consulter les pharmacies de garde en mode **online / offline** avec une gestion sécurisée des utilisateurs.

Le projet a été réalisé dans le cadre du module **M206 - Application Android sécurisée**.

---

## 🎯 Objectif du projet
Développer une application mobile sécurisée intégrant :
- Authentification utilisateur
- Validation des données
- Stockage local sécurisé
- API REST
- Mode offline
- Architecture propre (MVVM)

---

## 🚀 Fonctionnalités

### 🔐 Authentification sécurisée
- Login simulé : `admin@gmail.com / 1234`
- Validation email (format correct)
- Validation mot de passe
- Session utilisateur avec SharedPreferences sécurisées

---

### 🌐 API REST (Retrofit)
- Récupération des pharmacies depuis MockAPI
- Gestion des erreurs réseau

---

### 💾 Base de données locale (Room)
- Stockage des pharmacies
- Accès hors ligne
- Synchronisation automatique

---

### 🔄 Synchronisation Online / Offline
- Internet disponible → API + sauvegarde Room
- Offline → Lecture depuis Room

---

### 📋 Interface utilisateur
- Liste des pharmacies (RecyclerView)
- Détail d’une pharmacie
- Navigation Drawer
- Mode hors ligne indicator
- Loading progress bar

---

## 🏗️ Architecture
adapter/
model/
local/(Room Database)
service/(Retrofit)
repository/
view/
viewModel/
utils/

---

## 🔧 Technologies utilisées

- Kotlin
- Android Studio
- Retrofit
- Room Database
- MVVM Architecture
- SharedPreferences
- Material Design
- RecyclerView

---

## 🔐 Sécurité implémentée

- Validation des champs utilisateur
- Protection contre saisie invalide
- Stockage sécurisé des sessions
- Gestion des erreurs réseau
- Mode offline sécurisé
- (Bonus) Encrypted SharedPreferences

---

## 🌐 API utilisée

https://6a219dd6b1d0aaf32b4fc2af.mockapi.io/api/v1/

---

---

## 👨‍💻 Auteur

- Nom : Sara Saadi
- Projet : Android Sécurisé M206
- Année : 2025/2026

---

## ⭐ Améliorations possibles

- Login biométrique
- Animation UI
- Google Maps localisation pharmacie
- Notifications
- Dark mode

---

## 📌 Note
Projet réalisé dans un cadre pédagogique respectant les bonnes pratiques Android et les principes de sécurité mobile.
