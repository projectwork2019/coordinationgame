INSERT INTO game_session(voluntary_data) VALUES ('wsup?');
INSERT INTO game_session(voluntary_data) VALUES ('Hello darkness my old friend...');


INSERT INTO category(name) VALUES ('3-Nodes');
INSERT INTO category(name) VALUES ('4-Nodes');
INSERT INTO category(name) VALUES ('X-Shape');


INSERT INTO game(gameData)
VALUES
 (
 '{ "Name": "Test1", "edges": [11,22,33]}'
 );
INSERT INTO game(gameData)
VALUES
 (
 '{ "Name": "Test2", "edges": [12,21,33,44]}'
 );
 
 
INSERT INTO game_category VALUES (1,1);
INSERT INTO game_category VALUES (2,2);
INSERT INTO game_category VALUES (3,2);


INSERT INTO presentation(presentation_data, game_id)
VALUES
 (
 '{ "Name": "Presentation1"}',
 1
 );
 INSERT INTO presentation(presentation_data, game_id)
VALUES
 (
 '{ "Name": "Presentation2"}',
 1
 );
 INSERT INTO presentation(presentation_data, game_id)
VALUES
 (
 '{ "Name": "Presentation1"}',
 2
 );
 
 
INSERT INTO selection(confidence, times, selected_node, presentation_id) 
VALUES (4,1,2,1);
INSERT INTO selection(confidence, times, selected_node, presentation_id) 
VALUES (2,1,1,2);
INSERT INTO selection(confidence, times, selected_node, presentation_id) 
VALUES (5,1,3,3);
 
 
INSERT INTO game_session_selection VALUES (1,1);
INSERT INTO game_session_selection VALUES (2,1);
INSERT INTO game_session_selection VALUES (3,2);


-- Test query to get data of one game_session_id
SELECT game_session.game_session_id, selection.selection_id, selection.presentation_id, category.name
FROM game_session, game_session_selection, selection, presentation, game, game_category, category
WHERE game_session.game_session_id = 1
	AND game_session.game_session_id = game_session_selection.game_session_id
	AND selection.selection_id = game_session_selection.selection_id
	AND selection.presentation_id = presentation.presentation_id
	AND presentation.game_id = game.game_id
	AND game.game_id = game_category.game_id
	AND game_category.category_id = category.category_id;
 
