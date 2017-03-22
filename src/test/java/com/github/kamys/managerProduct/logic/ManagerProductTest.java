package com.github.kamys.managerProduct.logic;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ManagerProductTest {

    private final ManagerProduct manager = new ManagerProduct();

    @Test
    public void checkAllLayoutNotNull() throws Exception {
        List<Layout> layouts = manager.getAllLayout();
        assertNotNull(layouts);
    }

    @Test
    public void checkAllSectionNotNull() throws Exception {
        List<Section> goods = manager.getAllSection();
        assertNotNull(goods);
    }

    @Test
    public void saveLayout() throws Exception {
        Layout layout = addLayoutInManager();

        List<Layout> allLayout = manager.getAllLayout();
        assertThat(allLayout.size(), is(1));
        assertTrue(allLayout.contains(layout));
    }

    @Test
    public void saveSection() throws Exception {
        Section section = addSectionInManager();

        List<Section> allSection = manager.getAllSection();
        assertThat(allSection.size(), is(1));
        assertTrue(allSection.contains(section));
    }

    @Test
    public void updateSection() throws Exception {
        Section findSection = addSectionInManager();

        Section newSection = new Category();
        newSection.setName("Section_2");
        manager.updateSection(findSection, newSection);

        List<Section> allSection = manager.getAllSection();
        assertThat(allSection.size(), is(1));
        assertTrue(allSection.contains(newSection));
    }

    @Test
    public void updateLayout() throws Exception {
        Layout findLayout = new Layout();
        findLayout.setName("Layout_1");
        manager.saveLayout(findLayout);

        Layout newLayout = new Layout();
        newLayout.setName("Layout_2");
        manager.updateLayout(findLayout, newLayout);

        List<Layout> allLayout = manager.getAllLayout();
        assertThat(allLayout.size(), is(1));
        assertTrue(allLayout.contains(newLayout));
    }

    @Test
    public void deleteLayout() throws Exception {
        Layout findLayout = new Layout();
        manager.deleteLayout(findLayout);

        List<Layout> allLayout = manager.getAllLayout();
        assertThat(allLayout.size(), is(0));
    }

    @Test
    public void deleteSection() throws Exception {
        Section findSection = new Category();
        manager.deleteSection(findSection);

        List<Section> allSection = manager.getAllSection();
        assertThat(allSection.size(), is(0));
    }

    private Layout addLayoutInManager() {
        Layout layout = new Layout();
        manager.saveLayout(layout);
        return layout;
    }

    private Section addSectionInManager() {
        Section section = new Category();
        section.setName("Section_1");
        manager.saveSection(section);
        return section;
    }
}