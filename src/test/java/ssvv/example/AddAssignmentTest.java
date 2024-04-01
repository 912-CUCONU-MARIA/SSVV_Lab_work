package ssvv.example;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.TemaValidator;

public class AddAssignmentTest {

    TemaValidator vt;

    StudentXMLRepository strepo;
    TemaXMLRepository tmrepo;
    NotaXMLRepository ntrepo;
    Service service;

    @Before
    public void initData() {
        vt = new TemaValidator();
        tmrepo = new TemaXMLRepository(vt, "temetest.xml");
        service = new Service(strepo, tmrepo, ntrepo);
    }

    @Test
    public void testAddAssignmentInvalidId() {
        System.out.println("testAddAssignmentInvalidId");
        initData();
        int result;
        try {
            result = service.saveTema(null, "Desc tema", 14,13);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 1);
    }

    @Test
    public void testAddAssignmentInvalidDesc() {
        System.out.println("testAddAssignmentInvalidDesc");
        initData();
        int result;
        try {
            result = service.saveTema("5", null, 14,13);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 1);
    }

    @Test
    public void testAddAssignmentInvalidDeadline() {
        System.out.println("testAddAssignmentInvalidDeadline");
        initData();
        int result;
        try {
            result = service.saveTema("5", "Desc tema", -1,13);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 1);
    }

    @Test
    public void testAddAssignmentInvalidStartline() {
        System.out.println("testAddAssignmentInvalidStartline");
        initData();
        int result;
        try {
            result = service.saveTema("5", "Desc tema", 14,-1);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 1);
    }

    @Test
    public void testAddAssignmentValid() {
        System.out.println("testAddAssignmentValid");
        initData();
        int result=0;
        try {
            result = service.saveTema("5", "Desc tema", 14,13);
        } catch (Exception ve) {
            result = 1;
        }
        assert (result == 0);
    }

}
