package ssvv.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

public class AppTest
{

    StudentValidator vs;
    TemaValidator vt;
    NotaValidator vn;
    StudentXMLRepository strepo;
    TemaXMLRepository tmrepo;
    NotaXMLRepository ntrepo;
    Service service;

    @Before
    public void initData() {
        vs = new StudentValidator();
        vt = new TemaValidator();
        vn = new NotaValidator();
        strepo = new StudentXMLRepository(vs, "studentitest.xml");
        tmrepo = new TemaXMLRepository(vt, "temetest.xml");
        ntrepo = new NotaXMLRepository(vn, "notetest.xml");
        service = new Service(strepo, tmrepo, ntrepo);
    }

    @Test
    public void testAddStudentValidID() {
        System.out.println("testAddStudentValidID");
        initData();
        int result;
        try {
            result = service.saveStudent("13", "John Cena", 937);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 0);
    }

    @Test
    public void testAddStudentNullID() {
        System.out.println("testAddStudentNullID");
        initData();
        int result;
        try {
            result = service.saveStudent(null, "John Cena", 937);
        } catch (Exception ve) {
            result = 0;
        }
        assert (result == 1);
    }

    @Test
    public void testAddStudentEmptyID() {
        System.out.println("testAddStudentEmptyID");
        initData();
        int result;
        try {
            result = service.saveStudent("", "John Cena", 937);
        } catch (Exception ve) {
            result = 0;
        }
        assert (result == 1);
    }

    @Test
    public void testAddStudentWrongGroup() {
        System.out.println("testAddStudentWrongGroup");
        initData();
        int result;
        try {
            result = service.saveStudent("113", "John Cena", 999);
        } catch (Exception ve) {
            result = 0;
        }
        assert (result == 1);
    }

    @Test
    public void testAddStudentCorrectGroup() {
        System.out.println("testAddStudentCorrectGroup");
        initData();
        int result;
        try {
            result = service.saveStudent("114", "John Cena", 932);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 0);
    }

    @Test
    public void testAddStudentLowerBoundaryGroup() {
        System.out.println("testAddStudentLowerBoundaryGroup");
        initData();
        int result;
        try {
            result = service.saveStudent("113", "John Cena", 110);
        } catch (Exception ve) {
            result = 0;
        }
        assert (result == 1);
    }

    @Test
    public void testAddStudentUpperBoundaryGroup() {
        System.out.println("testAddStudentUpperBoundaryGroup");
        initData();
        int result;
        try {
            result = service.saveStudent("113", "John Cena", 938);
        } catch (Exception ve) {
            result = 0;
        }
        assert (result == 1);
    }

    @Test
    public void testAddStudentValidName() {
        System.out.println("testAddStudentValidName");
        initData();
        int result;
        try {
            result = service.saveStudent("113", "John Cena", 939);
        } catch (Exception ve) {
            result = 0;
        }
        assert (result == 1);
    }

    @Test
    public void testAddStudentNullName() {
        System.out.println("testAddStudentNullName");
        initData();
        int result;
        try {
            result = service.saveStudent("113", "", 939);
        } catch (Exception ve) {
            result = 0;
        }
        assert (result == 1);
    }
    @Test
    public void testAddStudentEmptyName() {
        System.out.println("testAddStudentEmptyName");
        initData();
        int result;
        try {
            result = service.saveStudent("113", "", 939);
        } catch (Exception ve) {
            result = 0;
        }
        assert (result == 1);
    }
}
