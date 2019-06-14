package com.mysql.dbeditor;

import com.mysql.dbeditor.entity.DbInserter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbeditorApplication {

	public static void main(String[] args) {
		DbInserter.insertUsers();
		SpringApplication.run(DbeditorApplication.class, args);
	}

}
