CREATE TABLE `book` (
`id` int(11) NOT NULL,

`brief` varchar(50) DEFAULT NULL,

`publish_year` int(11) DEFAULT NULL,

 `author` varchar(255) DEFAULT NULL,

 `title` varchar(50) DEFAULT NULL,

 PRIMARY KEY (`id`)
 )
ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (

`id` int(11) NOT NULL,

`name` varchar(255) DEFAULT NULL,

 `date_of_birth` date DEFAULT NULL,

 `email` varchar(50) DEFAULT NULL,

PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `employee_book` (

`book_id` int(11) NOT NULL,

`employee_id` int(11) NOT NULL,

 `id` int(11) NOT NULL,

PRIMARY KEY (`book_id`,`employee_id`),

KEY `fk_emplyee_idx` (`employee_id`),

CONSTRAINT `fk_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,

 CONSTRAINT `fk_emplyee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8