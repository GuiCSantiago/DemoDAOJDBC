package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("Test1 - FindByID");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("Test2 - FindByDepartment");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj:list) {
            System.out.println(obj  );
        }

        System.out.println("Test3 - FindAll");
        list = sellerDao.findAll();
        for (Seller obj:list) {
            System.out.println(obj  );
        }

        System.out.println("Test4 - SellerInsert");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com",new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = "+ newSeller.getId());

        System.out.println("Test5 - SellerUpdate");
        seller = sellerDao.findById(1);
        seller.setName("Joseph Matt");
        sellerDao.update(seller);
        System.out.println("Updated");

        System.out.println("Test6 - SellerDelete");
        sellerDao.deleteById(9);
        sellerDao.deleteById(11);
        System.out.println("Deleted 9, 11");
    }
}
