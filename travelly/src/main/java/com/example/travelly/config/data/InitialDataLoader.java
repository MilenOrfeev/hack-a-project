package com.example.travelly.config.data;

import com.example.travelly.model.Listing;
import com.example.travelly.model.User;
import com.example.travelly.repository.ListingRepository;
import com.example.travelly.repository.UserRepository;
import com.example.travelly.service.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Profile({ "default", "test" })
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final static Logger log = LoggerFactory.getLogger(InitialDataLoader.class);

    @Autowired
    private ListingService listingService;

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user1 = new User();
        user1.setEmail("user1.user1@user.com");
        user1.setUsername("Explorer");
        user1.setPassword("Password123");
        userRepository.save(user1);

        User user2 = new User();
        user2.setEmail("user2.user2@user.com");
        user2.setUsername("Foodie");
        user2.setPassword("OpenSesame");
        userRepository.save(user2);

        User user3 = new User();
        user3.setEmail("user3.user3@user.com");
        user3.setUsername("Student");
        user3.setPassword("Password123");
        userRepository.save(user3);



        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");

        Date alphaDate1 = null;
        Date alphaDate2 = null;


        Listing listingA = new Listing();
        listingA.setDestination("New York, New York");
        try {
            alphaDate1 = dateFormat.parse("2020-06-11");
            alphaDate2= dateFormat.parse("2020-06-18");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingA.setStartDate(alphaDate1);
        listingA.setEndDate(alphaDate2);
        listingA.setDescription("Let's go explore the Big Apple. Time's Square here we come!");
        listingRepository.save(listingA);
        log.info("Added listing (" + listingA.getId() + ") ");

        Listing listingB = new Listing();
        listingB.setDestination("Paris, France");
        try {
            alphaDate1 = dateFormat.parse("2020-05-01");
            alphaDate2= dateFormat.parse("2020-05-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingB.setStartDate(alphaDate1);
        listingB.setEndDate(alphaDate2);
        listingB.setDescription("Looking for travel companions to explore the fine arts of France. Bonus if you can be a translator!");
        listingB.setCapacity(100);
        listingRepository.save(listingB);
        log.info("Added listing (" + listingB.getId() + ") ");


        Listing listingC = new Listing();
        listingC.setDestination("London, England");
        try {
            alphaDate1 = dateFormat.parse("2020-01-01");
            alphaDate2= dateFormat.parse("2020-01-07");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingC.setStartDate(alphaDate1);
        listingC.setEndDate(alphaDate2);
        listingC.setCapacity(100);
        listingRepository.save(listingC);
        log.info("Added listing (" + listingC.getId() + ") ");

        Listing listingD = new Listing();
        listingD.setDestination("Cozumel, Mexico");
        try {
            alphaDate1 = dateFormat.parse("2020-09-18");
            alphaDate2= dateFormat.parse("2020-09-25");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingD.setStartDate(alphaDate1);
        listingD.setEndDate(alphaDate2);
        listingD.setDescription("Expedition to explore Mayan Ruins.");
        listingD.setCapacity(100);
        listingRepository.save(listingD);
        log.info("Added listing (" + listingD.getId() + ") ");

        Listing listingE = new Listing();
        listingE.setDestination("Stockholm, Sweden");
        try {
            alphaDate1 = dateFormat.parse("2020-12-20");
            alphaDate2= dateFormat.parse("2021-01-07");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingE.setStartDate(alphaDate1);
        listingE.setEndDate(alphaDate2);
        listingA.setDescription("Calling all foodies!");
        listingRepository.save(listingE);
        log.info("Added listing (" + listingE.getId() + ") ");

        Listing listingF = new Listing();
        listingF.setDestination("Las Vegas, Nevada");
        try {
            alphaDate1 = dateFormat.parse("2020-12-20");
            alphaDate2= dateFormat.parse("2021-01-07");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingF.setStartDate(alphaDate1);
        listingF.setEndDate(alphaDate2);
        listingF.setDescription("What happens in Vegas, stays in Vegas!");
        listingRepository.save(listingF);
        log.info("Added listing (" + listingF.getId() + ") ");

        Listing listingG = new Listing();
        listingG.setDestination("Barbados");
        try {
            alphaDate1 = dateFormat.parse("2020-12-20");
            alphaDate2= dateFormat.parse("2021-01-07");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingG.setStartDate(alphaDate1);
        listingG.setEndDate(alphaDate2);
        listingRepository.save(listingG);
        log.info("Added listing (" + listingG.getId() + ") ");

        Listing listingH = new Listing();
        listingH.setDestination("Trinidad");
        try {
            alphaDate1 = dateFormat.parse("2020-12-20");
            alphaDate2= dateFormat.parse("2021-01-07");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingH.setStartDate(alphaDate1);
        listingH.setEndDate(alphaDate2);
        listingH.setCapacity(100);
        listingRepository.save(listingH);
        log.info("Added listing (" + listingH.getId() + ") ");

        Listing listingI = new Listing();
        listingI.setDestination("Barcelona, Spain");
        try {
            alphaDate1 = dateFormat.parse("2020-12-20");
            alphaDate2= dateFormat.parse("2021-01-07");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listingI.setStartDate(alphaDate1);
        listingI.setEndDate(alphaDate2);
        listingI.setCapacity(100);
        listingRepository.save(listingI);
        log.info("Added listing (" + listingI.getId() + ") ");
    }
}
