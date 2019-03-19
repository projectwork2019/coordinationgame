
CREATE SCHEMA project_work;


CREATE TABLE project_work.game_session (
game_session_id SERIAL,
voluntary_data VARCHAR(500),
PRIMARY KEY(game_session_id),
UNIQUE (game_session_id));


CREATE TABLE project_work.game (
game_id SERIAL,
gamedata JSON NOT NULL,
PRIMARY KEY (game_id));


CREATE TABLE project_work.presentation (
presentation_id SERIAL,
presentation_data JSON NOT NULL,
game_id SERIAL,
PRIMARY KEY(presentation_id),
FOREIGN KEY (game_id) REFERENCES Game);


CREATE TABLE project_work.selection (
selection_id SERIAL,
confidence INT NOT NULL,
times INT NOT NULL,
selected_node INT NOT NULL,
presentation_id SERIAL,
PRIMARY KEY(selection_id, confidence, presentation_id, selected_node),
FOREIGN KEY (presentation_id) REFERENCES Presentation,
UNIQUE (selection_id));


CREATE TABLE project_work.game_session_selection (
selection_id SERIAL,
game_session_id SERIAL,
PRIMARY KEY (selection_id, game_session_id),
FOREIGN KEY (selection_id) REFERENCES selection(selection_id),
FOREIGN KEY (game_session_id) REFERENCES game_session(game_session_id));


CREATE TABLE project_work.category (
category_id SERIAL,
name VARCHAR(100) NOT NULL,
PRIMARY KEY (category_id)
UNIQUE (name));


CREATE TABLE project_work.game_category (
category_id SERIAL,
game_id SERIAL,
PRIMARY KEY (category_id, game_id),
FOREIGN KEY (game_id) REFERENCES Game,
FOREIGN KEY (category_id) REFERENCES Category);

