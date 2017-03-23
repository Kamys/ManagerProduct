package com.github.kamys.managerProduct.logic;

import java.util.List;

/**
 * This default implements for LogicFacade.
 */
public class LogicFacadeImpl implements LogicFacade {
    private List<Layout> layouts;
    private List<Section> sections;

    @Override
    public List<Layout> selectLayout() {
        return layouts;
    }

    @Override
    public List<Section> selectSection() {
        return sections;
    }

    @Override
    public Layout selectLayout(Layout layout) {
        return null;
    }

    @Override
    public Section selectSection(Section section) {
        return null;
    }

    @Override
    public void saveLayout(Layout layout) {

    }

    @Override
    public void saveSection(Section section) {

    }

    @Override
    public void updateSection(Section findSection, Section newSection) {

    }

    @Override
    public void updateLayout(Layout findLayout, Layout newLayout) {

    }

    @Override
    public void deleteLayout(Layout findLayout) {

    }

    @Override
    public void deleteSection(Section findSection) {

    }
}
