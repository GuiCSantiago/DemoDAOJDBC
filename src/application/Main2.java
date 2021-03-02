package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        System.out.println("Teste 1 - InsertDepartment");
        Department dep = new Department(null, "music");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        departmentDao.insert(dep);

        System.out.println("Teste 2 - FindDepartment");
        Department dep2 = departmentDao.findById(1);
        System.out.println(dep2);

        System.out.println("Teste 3 - FindAll");
        List<Department> list = departmentDao.findAll();
        for (Department dep3:
                list) {
            System.out.println(dep3);
        }

        System.out.println("Test4- Delete");

        System.out.println("Test5 - Update");
        Department dep4 = departmentDao.findById(6);
        dep4.setName("Brunaa");
        departmentDao.update(dep4);


    }
}
