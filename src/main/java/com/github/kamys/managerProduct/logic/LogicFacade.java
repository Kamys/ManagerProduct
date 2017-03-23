package com.github.kamys.managerProduct.logic;

import java.util.List;

/**
 * Using this facade for to work with logic library ManagerProduct.
 */
public class LogicFacade {
    private List<Layout> layouts;
    private List<Section> sections;

    /**
     * Use for select all {@link Layout}.
     *
     * @return all {@link Layout}.
     */
    List<Layout> selectLayout() {
        return layouts;
    }

    /**
     * Use for select all {@link Section}.
     *
     * @return all {@link Section}.
     */
    List<Section> selectSection() {
        return sections;
    }

    /**
     * Use for selection by parameters.
     *
     * @param layout contains parameters for selection.
     * @return found in the parameters.
     */
    Layout selectLayout(Layout layout) {
        return null;
    }

    /**
     * Use for selection by parameters.
     *
     * @param section contains parameters for selection.
     * @return found in the parameters.
     */
    Section selectSection(Section section) {
        return null;
    }

    /**
     * Save {@link Layout} in database;
     *
     * @param layout which need save;
     */
    void saveLayout(Layout layout) {

    }

    /**
     * Save {@link Section} in database;
     *
     * @param section which need save;
     */
    void saveSection(Section section) {

    }

    /**
     * Use for update {@link Section} in database.
     *
     * @param findSection contains parameters for finding {@link Section} for update.
     * @param newSection  replacement is for found is {@link Section}
     */
    void updateSection(Section findSection, Section newSection) {

    }

    /**
     * Use for update {@link Section} in database.
     *
     * @param findLayout contains parameters for finding {@link Layout} for update.
     * @param newLayout  replacement is for found is {@link Layout}.
     */
    void updateLayout(Layout findLayout, Layout newLayout) {

    }

    void deleteLayout(Layout findLayout) {

    }

    void deleteSection(Section findSection) {

    }
}
