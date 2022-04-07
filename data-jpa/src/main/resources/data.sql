INSERT INTO `category` (id, name, parent_id)
VALUES (1, 'electronics', NULL),
(2, 'smartphones', 1),
(3, 'cell_phones', 1),
(4, 'apple', 2),
(5, 'samsung', 2),
(6, 'motorola', 3),
(7, 'nokia', 3);

INSERT INTO `community` (id, name)
VALUES (1, 'Java'),
(2, 'Python');

INSERT INTO `member` (id, name, community_id)
VALUES (1, 'John', 1),
(2, 'Alex', 2);

INSERT INTO `organizer` (id, name, community_id)
VALUES (1, 'James', 1),
(2, 'Rossum', 2);