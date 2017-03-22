package com.github.kamys.managerProduct.logic;

import java.util.List;

/**
 * This facade is main for using library ManagerProduct.
 */
class ManagerProduct {
    private List<Layout> allLayout;
    private List<Section> allSection;

    /**
     * Use for get all {@link Layout}.
     *
     * @return all {@link Layout}.
     */
    List<Layout> getAllLayout() {
        return allLayout;
    }

    /**
     * Use for get all {@link Section}.
     *
     * @return all {@link Section}.
     */
    List<Section> getAllSection() {
        return allSection;
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
