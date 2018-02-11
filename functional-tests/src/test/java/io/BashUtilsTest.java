package io;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by serhii on 10.02.18.
 */
public class BashUtilsTest {

    private BashUtils bashUtils;

    @Test
    public void cat() throws Exception {
        String res = BashUtils.cat(BashUtils.class.getResource("test.txt").getFile());
        assertThat(res, containsString("line3"));
    }

    @Test(expected = FileNotFoundException.class)
    public void catNeg() throws Exception {
        String res = BashUtils.cat("unreal.txt");
    }

    @Test
    public void writeInto() throws Exception {
        boolean res = BashUtils.writeInto("res.txt", "Content", false);
        assertThat(res, is(true));
        assertThat(BashUtils.cat("res.txt"), containsString("Content"));
    }

    @Test
    public void writeIntoAppend() throws Exception {
        BashUtils.writeInto("res.txt", "Content1", true);
        BashUtils.writeInto("res.txt", "Content2", true);
        BashUtils.writeInto("res.txt", "Content3", true);
        assertThat(BashUtils.cat("res.txt"), containsString("Content2"));
    }

    @Test
    public void ls() throws Exception {
        List<String> ls = BashUtils.ls(".");
        assertThat(ls, hasItems("build.gradle", "src"));
    }

    @Test
    public void copy() throws Exception {
        boolean copy = BashUtils.copy(BashUtils.class.getResource("test.txt").getFile(), "test_copy.txt");
        assertThat(BashUtils.cat("test_copy.txt"), containsString("line3"));
    }

    @Test
    public void move() throws Exception {
        // create file before
        BashUtils.writeInto("test1.txt", "test content", false);
        boolean copy = BashUtils.move("test1.txt", "test2.txt");
        assertThat(BashUtils.cat("test2.txt"), containsString("content"));
    }

    @Test
    public void find() throws Exception {
        List<String> bashUtils = BashUtils.find(".", "BashUtils.class");

//        assertThat(bashUtils.size(), is(1));
        assertThat(bashUtils.get(0), containsString("BashUtils.class"));
    }

    @Test
    public void grep() throws Exception {
        List<String> line2 = BashUtils.grep("line1\nline2\nline3", "line2");
        assertThat(line2.size(), is(1));
        assertThat(line2.get(0), is("line2"));
    }

    @Test
    public void grepR() throws Exception {
        Map<String, String> line1 = BashUtils.grepR(".", "line1");
        line1.forEach((key, val) -> {
            assertThat(val, containsString("line1"));
        });

    }

}