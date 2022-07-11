package yjjeong.jpa.springdata.team.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import yjjeong.jpa.springdata.team.entity.Player;
import yjjeong.jpa.springdata.team.entity.Team;
import yjjeong.jpa.springdata.team.repository.PlayerRepository;
import yjjeong.jpa.springdata.team.repository.TeamRepository;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
@PropertySource({ "classpath:action.properties" })
public class TeamRunner implements ApplicationRunner {

    @Value("${repository.create}")
    private boolean create;
    @Value("${repository.read}")
    private boolean read;
    @Value("${repository.update}")
    private boolean update;
    @Value("${repository.delete}")
    private boolean delete;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

//        Team team = new Team();
//        team.setName("DWG KIA");
//        teamRepository.save(team);
//
//        Team team2 = new Team();
//        team2.setName("T1");
//        teamRepository.save(team2);
//
//        Team team3 = new Team();
//        team3.setName("HLE");
//        teamRepository.save(team3);
//
//        Player player = new Player();
//        player.setName("ShowMaker");
//        player.setTeam(team);
//        playerRepository.save(player);
//
//        Player player2 = new Player();
//        player2.setName("Faker");
//        player2.setTeam(team2);
//        playerRepository.save(player2);
//
//        Player player3 = new Player();
//        player3.setName("Chovy");
//        player3.setTeam(team3);
//        playerRepository.save(player3);

        Optional<Player> player = playerRepository.findById(5);
        System.out.println(player);
        // playerRepository.findAll().forEach(System.out::println);
        // ModelMapper modelMapper = new ModelMapper();
        // playerRepository.findAll().stream().map(m -> modelMapper.map(m,
        // PlayerDto.class)).collect(Collectors.toList());

        // teamRepository.deleteAll();
        // playerRepository.deleteAll();

    }
}
