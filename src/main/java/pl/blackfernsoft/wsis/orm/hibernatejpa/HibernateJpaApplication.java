package pl.blackfernsoft.wsis.orm.hibernatejpa;

import pl.blackfernsoft.wsis.orm.hibernatejpa.dao.CarDao;
import pl.blackfernsoft.wsis.orm.hibernatejpa.dao.CustomerDao;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Address;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Car;
import pl.blackfernsoft.wsis.orm.hibernatejpa.entity.Customer;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.CarType;
import pl.blackfernsoft.wsis.orm.hibernatejpa.enums.Color;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HibernateJpaApplication {

    private static final EntityManager em = HibernateUtil.getEntityManager();
    private static final CarDao carDao = new CarDao(em);
    private static final CustomerDao customerDao = new CustomerDao(em);

    public static void main(String[] args) {

//        try {
//
//            Car car1 = new Car();
//            car1.setName("Audi");
//            car1.setColor(Color.RED);
//            car1.setCarType(CarType.AWD);
//
//            Car car2 = new Car();
//            car2.setName("Volvo");
//            car2.setColor(Color.SILVER);
//            car2.setCarType(CarType.SEDAN);
//            car2.getRentalDates().add(new Date());
//            car2.getRentalDates().add(getAsDate("23-02-2018"));
//
//            em.getTransaction().begin();
//            carDao.save(car1);
//            carDao.save(car2);
//            em.getTransaction().commit();
//
//            List<Car> cars = carDao.findAll();
//            System.out.println("Number of Cars: " + cars.size());
//            for (Car car : cars){
//                System.out.println(car);
//            }
//
//
//
//        } finally {
//            // Close db connection
//            HibernateUtil.closeEntityManager();
//        }


        try {

            Car car1 = new Car();
            car1.setName("Audi");
            car1.setColor(Color.RED);
            car1.setCarType(CarType.AWD);

            Car car2 = new Car();
            car2.setName("Volvo");
            car2.setColor(Color.SILVER);
            car2.setCarType(CarType.SEDAN);
            car2.getRentalDates().add(new Date());
            car2.getRentalDates().add(getAsDate("23-02-2018"));

            em.getTransaction().begin();
            carDao.save(car1);
            carDao.save(car2);
            em.getTransaction().commit();

            List<Car> cars = carDao.findAll();
            System.out.println("Number of Cars: " + cars.size());
            for (Car car : cars) {
                System.out.println(car);
            }


            // Create customer with address

            Address address = new Address();
            address.setCountry("Poland");
            address.setCity("Wroclaw");
            address.setStreet("Legnicka");
            address.setNumber("12/7");


            em.getTransaction().begin();
            Customer customer = new Customer();
            customer.setFirstName("Stefan");
            customer.setLastName("Kowalski");
            customer.setCurrentDept(BigDecimal.valueOf(1300));
            customer.setCreationDate(new Date());
            customer.setAddress(address);
            customerDao.save(customer);
            em.getTransaction().commit();

            List<Customer> customers = customerDao.findAll();
            for (Customer customerEntity : customers) {
                System.out.println(customerEntity);
            }


        } finally {
            // Close db connection
            HibernateUtil.closeEntityManager();
        }
    }

    private static Date getAsDate(String dateString) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = df.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
