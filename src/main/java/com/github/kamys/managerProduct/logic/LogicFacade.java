package com.github.kamys.managerProduct.logic;

import java.util.List;

/**
 * Using this facade for to work with logic library ManagerProduct.
 */
public interface LogicFacade {
    /**
     * Use for select all {@link Layout}.
     *
     * @return all {@link Layout}.
     */
    List<Layout> selectLayout();

    /**
     * Use for select all {@link Section}.
     *
     * @return all {@link Section}.
     */
    List<Section> selectSection();

    /**
     * Use for selection by parameters.
     *
     * @param layout contains parameters for finding {@link Section} and update him.
     * @return found in the parameters.
     */
    Layout selectLayout(Layout layout);

    /**
     * Use for selection by parameters.
     *
     * @param section contains parameters for finding {@link Layout} and update him.
     * @return found in the parameters.
     */
    Section selectSection(Section section);

    /**
     * Save {@link Layout} in database;
     *
     * @param layout which need save;
     */
    void saveLayout(Layout layout);

    /**
     * Save {@link Section} in database;
     *
     * @param section which need save;
     */
    void saveSection(Section section);

    /**
     * Use for update {@link Section} in database.
     *
     * @param findSection contains parameters for finding {@link Section} and update him.
     * @param newSection  replacement is for found is {@link Section}
     */
    void updateSection(Section findSection, Section newSection);

    /**
     * Use for update {@link Section} in database.
     *
     * @param findLayout contains parameters for finding {@link Layout} and update him.
     * @param newLayout  replacement is for found is {@link Layout}.
     */
    void updateLayout(Layout findLayout, Layout newLayout);

    /**
     * Use for delete layout.
     *
     * @param findLayout contains parameters for finding {@link Layout} and update him
     */
    void deleteLayout(Layout findLayout);

    /**
     * Use for delete section.
     *
     * @param findSection contains parameters for finding {@link Section} and update him.
     */
    void deleteSection(Section findSection);
}
