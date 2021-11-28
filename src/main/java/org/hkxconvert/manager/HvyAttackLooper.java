package org.hkxconvert.manager;

import org.hkxconvert.FilePath;
import org.hkxconvert.ListExecutor.ListFixExecutor;
import org.hkxconvert.ListExecutor.annoInserterRemover;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import static org.hkxconvert.Const.ATTACK_WIN_ANNO;
import static org.hkxconvert.Const.COMBO_ANNO;

public class HvyAttackLooper extends FixManager{

    public HvyAttackLooper (File root, List<FilePath> filePaths) {
        super(root, filePaths);
    }


    @Override
    public void fixAnno() throws IOException {
        ListIterator<FilePath> li = getFilePaths().listIterator();
        while (li.hasNext()) {
            File txt = li.next().txt;
            annoInserterRemover fixer = new annoInserterRemover(txt, ATTACK_WIN_ANNO, COMBO_ANNO);
            if (fixer.insertAfter()) {
                System.out.println("successfully fixed:" + txt.getName());
            } else {
                li.remove();
                System.out.println("failed to fix:" + txt.getName());
            }
        }
    }
}
