package application.repos;

import application.entities.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article, Integer> {
}
