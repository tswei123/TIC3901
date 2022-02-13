CREATE TABLE `users` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `email` varchar(255),
  `password` varchar(255)
);

CREATE TABLE `diary` (
  `id` int PRIMARY KEY,
  `title` varchar(255),
  `created_at` timestamp,
  `content` varchar(255),
  `user_id` int
);

CREATE TABLE `diary_entry` (
  `id` int PRIMARY KEY,
  `entry` varchar(255)
);

ALTER TABLE `users` ADD FOREIGN KEY (`id`) REFERENCES `diary` (`user_id`);

ALTER TABLE `diary` ADD FOREIGN KEY (`id`) REFERENCES `diary_entry` (`id`);
