# **Rodrigo Javier Garrido Dagle**:: Android developer Test

## welcome!

## REPOSITORY

## **https://github.com/jardindunoix/apply_digital_rodrigo_javier_garrido_dagle**

![apply digital](https://a.storyblok.com/f/234030/556x192/227a4b0492/apply-digital-logo_full.png/m/556x192)

* Environment and language chosen
    - Android - Kotlin
    - Version Catalog

* The local.properties is ignored, so it is necesary to add:
    - **URL_BASE="https://hn.algolia.com"**
    - **URL_ENDPOINT="/api/v1/search_by_date?query=mobile/"**

* raw query:
    - **curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X
      GET https://hn.algolia.com/api/v1/search_by_date\?query\=mobile**

* CI CD with github actions, so check the action's workflow

* Jetpack Compose ui for the list view

* mappers for data usage outside of domain

* dependency injection with dagger hilt
* I try to emulate the flow with special branches

* Do I had to deal with problems? for sure!
    - The Swipe-to-Delete funcionality is depreated in some parts, so a had to ivestigate how to
      solve
      it.
    - The problem "Uresolved references in unit test": was a naming conflict issue
    - passing data with persistence in the viewmodel 

* I hope to demonstrate enough.

# Greetings!!!