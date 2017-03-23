package com.github.kamys.managerProduct.logic;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LogicFacadeImplTest {
    private final static int numberAddSection = 5;
    private final static int numberAddLayout = 5;
    private final LogicFacadeImpl logicFacade = new LogicFacadeImpl();

    private Section createSectionMock(String name) {
        Section mock = mock(Section.class);
        when(mock.getName()).thenReturn(name);
        return mock;
    }

    private Layout createLayoutMock(String name) {
        Layout mock = mock(Layout.class);
        when(mock.getName()).thenReturn(name);
        return mock;
    }

    private void checkLogicFacade() {
        List<Layout> layouts = logicFacade.selectLayout();
        List<Section> sections = logicFacade.selectSection();
        assertTrue(layouts.isEmpty());
        assertTrue(sections.isEmpty());
    }

    @Before
    public void setUp() throws Exception {
        checkLogicFacade();

        for (int i = 0; i < numberAddSection; i++) {
            logicFacade.saveSection(createSectionMock("Section_" + i));
        }

        for (int i = 0; i < numberAddLayout; i++) {
            logicFacade.saveLayout(createLayoutMock("Layout_" + i));
        }
    }

    @Test
    public void checkAllLayoutNotNull() throws Exception {
        List<Layout> layouts = logicFacade.selectLayout();
        assertNotNull(layouts);
    }

    @Test
    public void checkAllSectionNotNull() throws Exception {
        List<Section> goods = logicFacade.selectSection();
        assertNotNull(goods);
    }

    @Test
    public void selectLayout() throws Exception {
        final String nameForFind = "Layout_0";
        Layout findLayout = createLayoutMock(nameForFind);
        Layout selectLayout = logicFacade.selectLayout(findLayout);

        assertThat(selectLayout.getName(), is(nameForFind));
    }

    @Test
    public void selectSection() throws Exception {
        final String nameForFind = "Section_0";
        Section findSection = createSectionMock(nameForFind);
        Section selectSection = logicFacade.selectSection(findSection);

        assertThat(selectSection.getName(), is(nameForFind));
    }

    @Test
    public void saveLayout() throws Exception {
        Layout layout = createLayoutMock("Layout_ForTest");
        logicFacade.saveLayout(layout);

        List<Layout> allLayout = logicFacade.selectLayout();
        assertThat(allLayout.size(), is(1));
        assertTrue(allLayout.contains(layout));
    }

    @Test
    public void saveSection() throws Exception {
        Section section = createSectionMock("Section_ForTest");
        logicFacade.saveSection(section);

        List<Section> allSection = logicFacade.selectSection();
        assertThat(allSection.size(), is(1));
        assertTrue(allSection.contains(section));
    }

    @Test
    public void updateSection() throws Exception {
        Section findSection = createSectionMock("Section_1");

        Section newSection = createSectionMock("Section_update");
        logicFacade.updateSection(findSection, newSection);

        List<Section> allSection = logicFacade.selectSection();
        assertThat(allSection.size(), is(1));
        assertTrue(allSection.contains(newSection));
    }

    @Test
    public void updateLayout() throws Exception {
        Layout findLayout = createLayoutMock("Layout_1");

        Layout newLayout = createLayoutMock("Layout_update");
        logicFacade.updateLayout(findLayout, newLayout);

        List<Layout> allLayout = logicFacade.selectLayout();
        assertThat(allLayout.size(), is(1));
        assertTrue(allLayout.contains(newLayout));
    }

    @Test
    public void deleteLayout() throws Exception {
        Layout findLayout = createLayoutMock("Layout_1");
        logicFacade.deleteLayout(findLayout);

        List<Layout> allLayout = logicFacade.selectLayout();
        assertThat(allLayout.size(), is(numberAddLayout - 1));
        assertFalse(allLayout.contains(findLayout));
    }

    @Test
    public void deleteSection() throws Exception {
        Section findSection = createSectionMock("Section_1");
        logicFacade.deleteSection(findSection);

        List<Section> allSection = logicFacade.selectSection();
        assertThat(allSection.size(), is(numberAddSection - 1));
        assertFalse(allSection.contains(findSection));
    }
}