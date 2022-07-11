package yjjeong.jpa.springdata.board.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import yjjeong.jpa.springdata.board.entity.Board;
import yjjeong.jpa.springdata.board.repository.BoardRepository;

//@Component
@PropertySource({ "classpath:action.properties" })
public class BoardRunner implements ApplicationRunner {

    @Value("${repository.create}")
    private boolean create;
    @Value("${repository.read}")
    private boolean read;
    @Value("${repository.update}")
    private boolean update;
    @Value("${repository.delete}")
    private boolean delete;

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /* Custom interface method */
        // boardRepository.findByNameAndAge(board.getName(), board.getAge());

        Board board = Board.builder().name("yjjeong").age(29).build();

        if (create) {
            board = boardRepository.save(board);
        } else {
            board.setId(Long.valueOf(1));
        }

        if (read) {
            boardRepository.findAll().forEach(System.out::println);
            boardRepository.findById(board.getId());
        }

        if (update) {
            board.setAge(30);
            board = boardRepository.save(board);
        }

        if (read) {
            boardRepository.findById(board.getId());
        }

        if (delete) {
            boardRepository.deleteById(board.getId());
        }

    }
}
