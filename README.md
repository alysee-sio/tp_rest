# TP REST & SOAP
#### Service REST - Méthodes 

#### Création de sondage : 
Avant de commencer, on créer des sondages grâce l'adresse suivante 

@GET : 
`http://localhost:8080/tp_rest/webresources/sondage/init`

##### Consultation de la liste des sondages

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
DELETE `http://localhost:8080/tp_rest/webresources/sondage/suppressionSondage/{id}`

Ca supprimer le sondage dont on indique l'id

##### Modification d'un sondage existant
PUT `http://localhost:8080/tp_rest/webresources/sondage/modifierSondage`

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

