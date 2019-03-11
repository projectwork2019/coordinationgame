# Coordinationgame

## REST API
- Get all games:             `/api/games
- Get single game with ID:   `/api/games/{id}
- Post:                      `/games (GameDataObject must be included in the POST request body)
    - POST example:
        - Content-Type: application/json (raw)
        - Body: { 'gameDataObject': <Game Data JavaScript object reference here> }
