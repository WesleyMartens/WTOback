package server.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.entity.Category;
import server.repositories.CategoryRepository;

import java.util.Map;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepo;

    public CategoryController(){}

    Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/category/create")
    public ResponseEntity createCategory(@RequestBody Map<String, String> body){
        String name = body.get("name");

        try {
            categoryRepo.save(new Category(name));
            return new ResponseEntity(HttpStatus.OK);

        }catch (Exception ex) {
            this.logger.error("Creation failed");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
