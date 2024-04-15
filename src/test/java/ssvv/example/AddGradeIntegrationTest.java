package ssvv.example;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

public class AddGradeIntegrationTest {

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
    public void testIntegrationAddStudentValidID() {
        System.out.println("testIntegrationAddStudentValidID");
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
    public void testIntegrationAddAssignmentValid() {
        System.out.println("testIntegrationAddAssignmentValid");
        initData();
        int result = 0;
        try {
            result = service.saveTema("5", "Desc tema", 14, 13);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 0);
    }

    @Test
    public void testIntegrationAddGradeValid() {
        System.out.println("testIntegrationAddGradeValid");
        initData();
        int result = 0;
        try {
            result = service.saveNota("13", "5", 10, 14,"Perfect");
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 0);
    }

    @Test
    public void testAddGradeIntegration() {
        System.out.println("testAddGradeIntegration");
        initData();

        int result;
        try {
            result = service.saveStudent("13", "John Cena", 937);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 0);

        try {
            result = service.saveTema("5", "Desc tema", 14, 13);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 0);

        try {
            result = service.saveNota("13", "5", 10, 14,"Perfect");
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 0);
    }



}
