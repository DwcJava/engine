package demo;

import org.dwcj.App;
import org.dwcj.controls.Button;
import org.dwcj.controls.MultilineEdit;
import org.dwcj.controls.TextBox;
import org.dwcj.controls.TreeView;
import org.dwcj.events.ButtonPushEvent;
import org.dwcj.events.IDwcEvent;
import org.dwcj.exceptions.DwcAppInitializeException;
import org.dwcj.panels.AppPanel;

public class TreeDemo extends App {

    @Override
    public void run() throws DwcAppInitializeException {

        new TreeDemoApp();
    }

    public class TreeDemoApp extends AppPanel {

        private final TreeView tree;

        private final MultilineEdit multilineEdit;

        public TreeDemoApp() throws DwcAppInitializeException {

            super();

            //setting some styles of the app panel itself
            setStyle("display", "inline-grid");
            setStyle("grid-template-columns", "1fr 2fr");
            setStyle("gap", "20px");
            setStyle("left", "20px");
            setStyle("top", "20px");
            setStyle("border", "1px dotted");
            setStyle("padding", "10px");

            Button collapseButton = new Button("Collapse All");
            add(collapseButton);
            collapseButton.onClick(this::collapseAll);

            Button expandButton = new Button("Expand All");
            add(expandButton);
            expandButton.onClick(this::expandAll);


            tree = new TreeView();
            add(tree);

            tree.setRoot(0,"root");
            tree.addExpandableNode(1,0,"child1");
            tree.addNode(2,0,"child2");
            tree.addNode(3,0,"child3");
            tree.insertNode(6,1,"child6",0);
            tree.insertNode(4,1,"child4",0);
            tree.insertExpandableNode(5,1,"child5",1);

            //log events
            tree.onGainedFocus(this::logEvent);
            tree.onLostFocus(this::logEvent);
            tree.onSelect(this::logEvent);
            tree.onDeselect(this::logEvent);
            tree.onExpand(this::logEvent);
            tree.onCollapse(this::logEvent);
            tree.onEditStopped(this::logEvent);
            tree.onDoubleClick(this::logEvent);




            multilineEdit = new MultilineEdit();
            add(multilineEdit);
            multilineEdit.setVerticalScrollable(true);
            multilineEdit.setHorizontalScrollable(true);
            multilineEdit.setStyle("width","400px");
            multilineEdit.setStyle("height","500px");
        }

        private void collapseAll(ButtonPushEvent ev) {
            tree.collapseTreeFromNode(tree.getRoot());
            multilineEdit.addParagraph(-1, (multilineEdit.getCurrentParagraphIndex() + 1) + ". " + "Method: collapseTreeFromNode(tree.getRoot())");
        }

        private void expandAll(ButtonPushEvent ev) {
            tree.expandTreeFromNode(tree.getRoot());
            multilineEdit.addParagraph(-1, (multilineEdit.getCurrentParagraphIndex() + 1) + ". " + "Method: expandTreeFromNode(tree.getRoot())");
        }

        private void logEvent(IDwcEvent event) {
            multilineEdit.addParagraph(-1, (multilineEdit.getCurrentParagraphIndex() + 1) + ". " + event.toString());
        }
    }
}


