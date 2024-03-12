package iframe;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTests;
import pages.WysiwygEditorPage;

/**
 * All tests for login functionality
 */
public class WysiwygEditorTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        WysiwygEditorPage editorPage = homePage.clickWYSIWYGEditor();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.clearTextArea();
        editorPage.setTextArea(text1);
        editorPage.decreaseIndent();
        editorPage.setTextArea(text2);

        Assert.assertEquals(editorPage.getTextArea(), text1+text2, "Text area from editor is incorrect");
    }

}
