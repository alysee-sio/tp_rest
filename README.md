# TP REST & SOAP

Travail avec l'IDE Netbeans 8.0.2 - Serveur GlassFish

## I - Service REST - Méthodes 

##### Création de sondage : 
Avant de commencer, on créer des sondages grâce l'adresse suivante 

@GET : `http://localhost:8080/tp_rest/webresources/sondage/init`

Réponse : ```Questionnaire cree```

##### Consultation de la liste des sondages : Questionnaire

@GET : `http://localhost:8080/tp_rest/webresources/sondage/consulterQuestionnaire`

Réponse :


```json
{  
   "sondages":[  
      {  
         "id":1,
         "intitule":"Quelle est la capitale de la France",
         "options":[  
            {  
               "id":1,
               "nbVotes":0,
               "texte":"Clermont-Ferrand"
            },
            {  
               "id":2,
               "nbVotes":0,
               "texte":"Lyon"
            },
            {  
               "id":3,
               "nbVotes":0,
               "texte":"Paris"
            }
         ]
      },
      {  
         "id":2,
         "intitule":"Quelle est la capitale de l'Australie",
         "options":[  
            {  
               "id":9,
               "nbVotes":0,
               "texte":"Sydney"
            },
            {  
               "id":7,
               "nbVotes":0,
               "texte":"Canberra"
            },
            {  
               "id":8,
               "nbVotes":0,
               "texte":"Adelaide"
            }
         ]
      }
   ]
}
```

##### Consultation d'un sondage en particulier
@GET `http://localhost:8080/tp_rest/webresources/sondage/consulterUnSondage/1`

Réponse :


```json
{  
   "id":1,
   "intitule":"Quelle est la capitale de la France",
   "options":[  
      {  
         "id":1,
         "nbVotes":0,
         "texte":"Clermont-Ferrand"
      },
      {  
         "id":2,
         "nbVotes":0,
         "texte":"Lyon"
      },
      {  
         "id":3,
         "nbVotes":0,
         "texte":"Paris"
      }
   ]
}
```

##### Création d'un nouveau sondage

@POST `http://localhost:8080/tp_rest/webresources/sondage/creationSondage`

````{  
   "id":3,
   "intitule":"Quelle est la capitale de l'Espagne",
   "options":[  
      {  
         "id":1,
         "nbVotes":0,
         "texte":"Madrid"
      },
      {  
         "id":2,
         "nbVotes":0,
         "texte":"Barcelone"
      },
      {  
         "id":3,
         "nbVotes":0,
         "texte":"Rossas"
      }
   ]
}``


##### Suppression d'un sondage
@DELETE `http://localhost:8080/tp_rest/webresources/sondage/suppressionSondage/{id}`

Ca supprimer le sondage dont on indique l'id

##### Modification d'un sondage existant
@PUT `http://localhost:8080/tp_rest/webresources/sondage/modifierSondage`

Réponse : 

```json
{  
   "id":1,
   "intitule":"Quelle est la capitale de la France",
   "options":[  
      {  
         "id":1,
         "nbVotes":0,
         "texte":"Clermont-Ferrand"
      },
      {  
         "id":2,
         "nbVotes":0,
         "texte":"Marseille"
      },
      {  
         "id":3,
         "nbVotes":0,
         "texte":"Paris"
      }
   ]
}
```

Remarque : 

- Pour tester les @POST, @DELETE et @PUT, il faudra ce servir de l'extension chrome Advanced REST client.



## I - Service SOAP
 
Lien fourni par GlassFish Server : http://mbp-de-alysee:8080/tp_rest/sondage?WSDL

Utilisation de Wizdler : Permet d'analyser les fichiers WSDL et génère des messages SOAP

##### Création de sondage :
 
Request : 

```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <createQuestionnaire xmlns="http://mbp-de-alysee:8080/tp_rest/Sondage"></createQuestionnaire>
    </Body>
</Envelope> 
```

Réponse : Renvoi ''void'

```xml
<?xml version="1.0" encoding="UTF-8"?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body/>
</S:Envelope>
```

##### Consultation de la liste des sondages : Questionnaire

Request : 

```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <getQuestionnaire xmlns="http://mbp-de-alysee:8080/tp_rest/Sondage"></getQuestionnaire>
    </Body>
</Envelope>
```

Réponse : Les deux sondages avec leurs attributs

```xml
<?xml version="1.0" encoding="UTF-8"?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getQuestionnaireResponse xmlns:ns2="http://mbp-de-alysee:8080/tp_rest/Sondage">
            <sondages>
                <id>1</id>
                <intitule>Quelle est la capitale de la France</intitule>
                <options>
                    <id>1</id>
                    <texte>Clermont-Ferrand</texte>
                    <nbVotes>0</nbVotes>
                </options>
                <options>
                    <id>2</id>
                    <texte>Lyon</texte>
                    <nbVotes>0</nbVotes>
                </options>
                <options>
                    <id>3</id>
                    <texte>Paris</texte>
                    <nbVotes>0</nbVotes>
                </options>
            </sondages>
            <sondages>
                <id>2</id>
                <intitule>Quelle est la capitale de l'Australie</intitule>
                <options>
                    <id>9</id>
                    <texte>Sydney</texte>
                    <nbVotes>0</nbVotes>
                </options>
                <options>
                    <id>7</id>
                    <texte>Canberra</texte>
                    <nbVotes>0</nbVotes>
                </options>
                <options>
                    <id>8</id>
                    <texte>Adelaide</texte>
                    <nbVotes>0</nbVotes>
                </options>
            </sondages>
        </ns2:getQuestionnaireResponse>
    </S:Body>
</S:Envelope>
```

##### Consultation d'un sondage en particulier

Request : 

```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <getSondageId xmlns="http://mbp-de-alysee:8080/tp_rest/Sondage">1</getSondageId>
    </Body>
</Envelope>
```

Reponse : Le sondage dont l'id vaut 1

```xml
<?xml version="1.0" encoding="UTF-8"?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:getSondageIdResponse xmlns:ns2="http://mbp-de-alysee:8080/tp_rest/Sondage">
            <id>1</id>
            <intitule>Quelle est la capitale de la France</intitule>
            <options>
                <id>1</id>
                <texte>Clermont-Ferrand</texte>
                <nbVotes>0</nbVotes>
            </options>
            <options>
                <id>2</id>
                <texte>Lyon</texte>
                <nbVotes>0</nbVotes>
            </options>
            <options>
                <id>3</id>
                <texte>Paris</texte>
                <nbVotes>0</nbVotes>
            </options>
        </ns2:getSondageIdResponse>
    </S:Body>
</S:Envelope>
```

##### Création d'un nouveau sondage

Request : 

```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <createSondage xmlns="http://mbp-de-alysee:8080/tp_rest/Sondage">
            <id xmlns="">4</id>
            <intitule xmlns="">Ceci est mon nouveau sondage ?</intitule>
            <!-- Optional -->
            <options xmlns="">
                <id>3</id>
                <texte>vrai</texte>
                <nbVotes>0</nbVotes>
            </options>
            <options xmlns="">
                <id>4</id>
                <texte>faux</texte>
                <nbVotes>0</nbVotes>
            </options>
        </createSondage>
    </Body>
</Envelope>
```

Reponse : Sondage avec pour id 4 crée

```xml
<?xml version="1.0" encoding="UTF-8"?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:createSondageResponse xmlns:ns2="http://mbp-de-alysee:8080/tp_rest/Sondage">
            <id>4</id>
            <intitule>Ceci est mon nouveau sondage ?</intitule>
            <options>
                <id>3</id>
                <texte>vrai</texte>
                <nbVotes>0</nbVotes>
            </options>
            <options>
                <id>4</id>
                <texte>faux</texte>
                <nbVotes>0</nbVotes>
            </options>
        </ns2:createSondageResponse>
    </S:Body>
</S:Envelope>
```

##### Suppression d'un sondage

Request : 

```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <deleteSondage xmlns="http://mbp-de-alysee:8080/tp_rest/Sondage">4</deleteSondage>
    </Body>
</Envelope>
```

Réponse : Sondage d'id 4, supprimé
 
```xml
<?xml version="1.0" encoding="UTF-8"?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body/>
</S:Envelope>
```

##### Modification d'un sondage existant

Request : 

```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <updateSondage xmlns="http://mbp-de-alysee:8080/tp_rest/Sondage">
            <id xmlns="">1</id>
            <intitule xmlns="">Je change la question et les options de l'id 1 ?</intitule>
            <!-- Optional -->
            <options xmlns="">
                <id>3</id>
                <texte>vrai</texte>
                <nbVotes>0</nbVotes>
            </options><options xmlns="">
                <id>4</id>
                <texte>faux</texte>
                <nbVotes>0</nbVotes>
            </options><options xmlns="">
                <id>9</id>
                <texte>je ne sais </texte>
                <nbVotes>0</nbVotes>
            </options>
        </updateSondage>
    </Body>
</Envelope>
```

Reponse : Modification de la question et des réponses pour le sondage dont l'id vaut 1


```xml
<?xml version="1.0" encoding="UTF-8"?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:updateSondageResponse xmlns:ns2="http://mbp-de-alysee:8080/tp_rest/Sondage">
            <id>1</id>
            <intitule>Je change la question et les options de l'id 1 ?</intitule>
            <options>
                <id>3</id>
                <texte>vrai</texte>
                <nbVotes>0</nbVotes>
            </options>
                <id>4</id>
                <texte>faux</texte>
                <nbVotes>0</nbVotes>
            </options>
                <id>9</id>
                <texte>je ne sais </texte>
                <nbVotes>0</nbVotes>
            </options>
        </ns2:updateSondageResponse>
    </S:Body>
</S:Envelope>
```