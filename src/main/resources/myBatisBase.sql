DROP TABLE IF EXISTS employer;
DROP TABLE IF EXISTS employee;

CREATE TABLE employer (
  id INT AUTO_INCREMENT,
  company VARCHAR(200)
);

CREATE TABLE employee (
  id INT AUTO_INCREMENT,
  name VARCHAR(200),
  employer_id INT,

  FOREIGN KEY (employer_id) REFERENCES employer(id)
)