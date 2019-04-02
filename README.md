# Coordinationgame

## REST API
- Get all games:             `/api/games`
- Get single game with ID:   `/api/games/{id}`
- Post:                      `/games (GameDataObject must be included in the POST request body)`
    - POST example:
        - `Content-Type: application/json (raw)`
        - `Body: { 'gameDataObject': <Game Data JavaScript object reference here> }`

## REST API Security
- First version of REST API security is based on HTTP Basic Authentication
	- HTTP GET request to /api/games is unrestricted = everyone can read the games (no need to auth to play the game)
	- HTTP POST, PUT, DELETE require authorization
	- Auth is stateless, no cookie or session identifier saved
	
	- You can test with Postman, by setting Authorization to Basic Auth
	
	![Image of Postman authorization](https://github.com/projectwork2019/coordinationgame/Postman_auth.png)