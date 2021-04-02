# OAuth2 resource server demonstration

  Table of contents

  * [**About the application**](#about-the-application)
  * [**Version history**](#version-history)

## **About the application**

This application is a demonstration of implementing a Spring Boot resource server application secured with OAuth2. It performs the following:

  * Secures all HTTP access, unless whitelisted otherwise
  * Validates the cryptographic signature of the access token passed by the client
  * Performs the actual business logic, and return the result to the client
<br/>
<br/>
Note: 
<br/>
Git Repository for the client application:
<br/>
https://github.com/patrickpycheung/oauth2-demo-client
<br/>
<br/>
<img src="https://bn1301files.storage.live.com/y4mTBfiib2UCkcdu7XOxbV7uh9TPz_o-jCeBZdf-lTzdWEqbJdz6lueBVNNCvmM71E6n-sUDG3bMmd7xMFbhooFMROxwZMn1uMhhQGq4os6KkiK6o-Yoejxyet9Pp8oOID_0UpXpHormxaiMeqmQFMczTuizVkncMEgBuU0pDlOiO0IBJGz1REZ_12es8L-5rPS?width=848&height=218&cropmode=none" alt="Sample_Response_To_Client">

## **Version history**

  | Editor | Version | Date |Description|
  | --- | --- | --- | --- |
  | Patrick Cheung | 1.0.0| 2 Apr 2021 |Initial release|
