package com.example.level1.Quizes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyQuiz1.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        //T1
        final String SQL_CREATE_QUESTIONS_TABLET11 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET11 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT11 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T11 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T11 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T11 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT11 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLET12 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET12 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT12 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T12 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T12 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T12 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT12 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLET13 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET13 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT13 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T13 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T13 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T13 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT13 + " INTEGER" +
                ")";

       //C1
        final String SQL_CREATE_QUESTIONS_TABLEC11 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC11 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC11 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C11 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C11 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C11 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC11 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLEC12 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC12 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC12 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C12 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C12 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C12 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC12 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLEC13 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC13 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC13 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C13 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C13 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C13 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC13 + " INTEGER" +
                ")";

        //T2
        final String SQL_CREATE_QUESTIONS_TABLET21 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET21 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT21 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T21 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T21 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T21 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT21 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLET22 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET22 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT22 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T22 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T22 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T22 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT22 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLET23 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET23 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT23 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T23 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T23 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T23 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT23 + " INTEGER" +
                ")";

            //C2
        final String SQL_CREATE_QUESTIONS_TABLEC21 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC21 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC21 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C21 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C21 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C21 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC21 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLEC22 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC22 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC22 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C22 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C22 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C22 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC22 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLEC23 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC23 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC23 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C23 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C23 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C23 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC23 + " INTEGER" +
                ")";


        //T3
        final String SQL_CREATE_QUESTIONS_TABLET31 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET31 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT31 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T31 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T31 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T31 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT31 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLET32 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET32 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT32 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T32 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T32 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T32 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT32 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLET33 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMET33 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONT33 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1T33 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2T33 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3T33 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRT33 + " INTEGER" +
                ")";

        //C3
        final String SQL_CREATE_QUESTIONS_TABLEC31 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC31 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC31 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C31 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C31 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C31 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC31 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLEC32 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC32 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC32 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C32 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C32 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C32 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC32 + " INTEGER" +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLEC33 = "CREATE TABLE " +
                QuizContact.QuestionsTable.TABLE_NAMEC33 + " ( " +
                QuizContact.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContact.QuestionsTable.COLUMN_QUESTIONC33 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION1C33 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION2C33 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_OPTION3C33 + " TEXT, " +
                QuizContact.QuestionsTable.COLUMN_ANSWER_NRC33 + " INTEGER" +
                ")";


      //T1
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET11);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET12);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET13);

      //C1
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC11);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC12);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC13);

        //T2
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET21);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET22);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET23);

       //C2
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC21);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC22);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC23);

        //T3
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET31);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET32);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLET33);

        //C3
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC31);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC32);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLEC33);



        //T11
        fillQuestionsTableT11();
        fillQuestionsTableT12();
        fillQuestionsTableT13();

        //C11
        fillQuestionsTableC11();
        fillQuestionsTableC12();
        fillQuestionsTableC13();

        //T21
        fillQuestionsTableT21();
        fillQuestionsTableT22();
        fillQuestionsTableT23();

        //C21
        fillQuestionsTableC21();
        fillQuestionsTableC22();
        fillQuestionsTableC23();

        //T31
        fillQuestionsTableT31();
        fillQuestionsTableT32();
        fillQuestionsTableT33();

        //31
        fillQuestionsTableC31();
        fillQuestionsTableC32();
        fillQuestionsTableC33();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //T1
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET11);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET12);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET13);

       //C1
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC11);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC12);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC13);

        //T2
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET21);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET22);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET23);

        //C2
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC21);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC22);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC23);

        //T3
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET31);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET32);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMET33);

        //C3
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC31);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC32);
        db.execSQL("DROP TABLE IF EXISTS " +  QuizContact.QuestionsTable.TABLE_NAMEC33);

        onCreate(db);
    }

    //T11
    private void fillQuestionsTableT11() {
        QuestionsT11 q1 = new QuestionsT11("اول شكل من اشكال الكنيسة هو ......", "الفردوس", "خيمة الاجتماع", "الهيكل ", 1);
        addQuestionT11(q1);
        QuestionsT11 q2 = new QuestionsT11("في الفردوس كان ادم بحاجة الي بناء هيكل لكي يتكلم مع الله ؟", "صح", "غلط", "...... ", 2);
        addQuestionT11(q2);
        QuestionsT11 q3 = new QuestionsT11("اول مذبح في العهد القديم .......", "بني ادم مذبح بعد سقوطة من الفردوس", "بني نوح مذبح بعد خروجة  من الفلك بعد جفاف الارض من  الطوفان", "الاجابتين غلط ", 2);
        addQuestionT11(q3);
        QuestionsT11 q4 = new QuestionsT11("خيمة الاجتماع من تصميم مين ؟", "الله  بعد ان صام موسي 40 يوم ", "احد العمال  من شعب بني اسرائيل", "موسي  ", 1);
        addQuestionT11(q4);
        QuestionsT11 q5 = new QuestionsT11("ما معني كلمة  علية ؟", "مكان  الطعام ", "حجرة فوق البيت كانوا يصلون فيها قديما", "الاجابتين غلط", 2);
        addQuestionT11(q5);
        QuestionsT11 q6 = new QuestionsT11("في علية مارمرقس تأسس سر ايه ؟", "الافخارستيا", "الزيجة ", "المعمودية ", 1);
        addQuestionT11(q6);
        QuestionsT11 q7 = new QuestionsT11("في علية مارمرقس  ظهر المسيح لتوما وحده  بدون التلاميذ؟", "صح ", "غلط ", "......", 2);
        addQuestionT11(q7);
        QuestionsT11 q8 = new QuestionsT11("ما هي  اول كنيسة ؟ ", "بيت بطرس الرسول", "علية يوحنا المعمدان", "علية مار مرقس", 3);
        addQuestionT11(q8);

        QuestionsT11 q9 = new QuestionsT11("حل الروح القدس علي التلاميذ وهم مجتمعين في ........", "علية مارمرقس", "الهيكل ", "الكنيسة ", 1);
        addQuestionT11(q9);
        QuestionsT11 q10 = new QuestionsT11("الكنيسة بتتبني  علي شكل اية ؟", "صليب و مستطيل و مثلث", "صليب و سفينة و دائرة", "سفينة و سلم و سماء", 2);
        addQuestionT11(q10);
        QuestionsT11 q11 = new QuestionsT11("تم اختيار ..... الرسول بدلا من يهوذا ", "بَرثُولَماوُس", "يوحنا ", "متياس ", 3);
        addQuestionT11(q11);
        QuestionsT11 q12 = new QuestionsT11("الكنيسة بتتبني علي شكل صليب عشان ايه؟", "لان الصليب هو طريق خلاصنا", "ابونا عايز كده", " شكلة حلو", 1);
        addQuestionT11(q12);
        QuestionsT11 q13 = new QuestionsT11("الكنيسة بتتبني علي شكل سفينة  عشان ايه؟", "رمز لمركب بطرس الرسول", "رمز لفلك نوح", "الاجابتين صح", 2);
        addQuestionT11(q13);
        QuestionsT11 q14 = new QuestionsT11(".......المكان المخصص لوقوف الشمامسة ؟؟", "الخورس ", "صحن الكنيسة ", "الهيكل ", 1);
        addQuestionT11(q14);
        QuestionsT11 q15 = new QuestionsT11("الكنيسة بتتبني علي شكل دائرة  عشان ايه؟", "الدايرة ليها نهاية وبداية", "الدايره ليس لها نهاية ولا بداية زي ربنا", "شبة صينية التناول", 2);
        addQuestionT11(q15);
        QuestionsT11 q16 = new QuestionsT11("في  الكنيسة نصلي  في اتجاة ........", "الغرب ", "الشمال ", "الشرق ", 3);
        addQuestionT11(q16);

        QuestionsT11 q17 = new QuestionsT11("ما هو لون ستر الهيكل في وقت اسبوع الالام؟", "اسود", "احمر", "ابيض", 1);
        addQuestionT11(q17);
        QuestionsT11 q18 = new QuestionsT11("ما هو لون ستر الهيكل في فترة الخماسين ؟", "احمر ", "ابيض", "اسود", 2);
        addQuestionT11(q18);
        QuestionsT11 q19 = new QuestionsT11("لماذا ننظر في اتجاة الشرق عند الصلاة ؟", "لان الشرق مكان الفردوس واحنا بنطلب نرجع تاني للفردوس", "لان المسيح سوف يأتي من جة الشرق في المجئ الثاني", "الاجابتين صح ", 3);
        addQuestionT11(q19);
        QuestionsT11 q20 = new QuestionsT11("مين اللي ممكن يدخل الهيكل؟", "الشمامسة ", "الشعب", "البنات ", 1);
        addQuestionT11(q20);
        QuestionsT11 q21 = new QuestionsT11("ممكن نتكلم بداخل الهيكل ؟", "صح", "غلط", "......", 2);
        addQuestionT11(q21);
        QuestionsT11 q22 = new QuestionsT11("نحن ندخل الهيكل احتراما لجسد ربنا وهنا نتذكر قول الله لموسي ......", "فقال الرب أني قد رأيت مذلة شعبي الذي في مصر وسمعت صراخهم من أجل مسخريهم أني علمت أوجاعهم", "يا موسى اخلع نعليك" +
                "لان الموضع الذي أنت فيه مقدس", "أني أكون معك وهذه تكون لك العلامة أني أرسلتك حينما تخرج الشعب من مصر تعبدون الله على هذا الجبل.", 2);
        addQuestionT11(q22);
        QuestionsT11 q23 = new QuestionsT11("اين مكان المذبح ؟", "علي يمين الهيكل", "في وسط الهيكل", "علي يسار الهيكل", 2);
        addQuestionT11(q23);
        QuestionsT11 q24= new QuestionsT11("........ هو تجويف في الحائط الشرقي للهيكل ويطلق علية حضن الاب ويوضع فية صورة المسيح ضابط الكل ", "الدرج ", "الدياكونيكون ", "الشرقية ", 3);
        addQuestionT11(q24);
        QuestionsT11 q25 = new QuestionsT11("الدرج هو ....... درجات نصف دائرية باستدارة حائط الهيكل الشرقي ", "5", " 7", "3 ", 2);
        addQuestionT11(q25);
    }

    private void addQuestionT11(QuestionsT11 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT11, question.getQuestionT11());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T11, question.getOption1T11());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T11, question.getOption2T11());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T11, question.getOption3T11());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT11, question.getAnswerNrT11());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET11, null, cv);
    }

    public ArrayList<QuestionsT11> getAllQuestionsT11() {
        ArrayList<QuestionsT11> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET11, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT11 question = new QuestionsT11();
                question.setQuestionT11(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT11)));
                question.setOption1T11(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T11)));
                question.setOption2T11(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T11)));
                question.setOption3T11(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T11)));
                question.setAnswerNrT11(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT11)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    // T12
    private void fillQuestionsTableT12() {
        QuestionsT12 q1 = new QuestionsT12("يصنع المذبح من ......", "الخشب و المعدن و الحجر ", "الورق والحجر والخشب", "الخشب والعظام و الذهب ", 1);
        addQuestionT12(q1);
        QuestionsT12 q2 = new QuestionsT12("لماذا يصنع المذبح من الخشب ؟", "لان الخشب رخيص في الثمن ", "اشارة للصليب ", "اشارة للسيدة العذراء", 2);
        addQuestionT12(q2);
        QuestionsT12 q3 = new QuestionsT12("ما هو شكل المذبح ؟", "دائرة ", "مثلث ", "مكعب ", 3);
        addQuestionT12(q3);
        QuestionsT12 q4 = new QuestionsT12("القبة علي المذبح تقوم علي ...... اعمدة وفوقها صليب ", "4", "5", "6", 1);
        addQuestionT12(q4);
        QuestionsT12 q5 = new QuestionsT12("الابروسفارين الذي يوضع علي الحمل والكأس هو الغطاء .... من اغطية المذبح", "الاول ", "الثالث ", "الثاني ", 2);
        addQuestionT12(q5);
        QuestionsT12 q6 = new QuestionsT12("اللوح المقدس هو لوح ....... ويرسم علي اللوح المقدس الحرفان الالفا والاوميجا ", "معدني ", "ذهبي ", "خشبي ", 3);
        addQuestionT12(q6);
        QuestionsT12 q7 = new QuestionsT12("تتم تدشين اواني المذبح بزيت ......؟", "الميرون ", "الزيتون ", "سمسم", 1);
        addQuestionT12(q7);
        QuestionsT12 q8 = new QuestionsT12("........ هي قطعة  من القماش مستديرة او مربعة عادة ما تكون من اللون الابيض او الاحمر وتكون مفروشة علي المذبح وتغطي الصينية والكاس", "المستير ", "اللفائف", "البشارة ", 2);
        addQuestionT12(q8);

        QuestionsT12 q9 = new QuestionsT12(".......... هو اناء يحتوي علي مزيج الخمر والماء الذي يتحول الي دم المسيح ", "الملعقة", "درج البخور", "الكاس ", 3);
        addQuestionT12(q9);
        QuestionsT12 q10 = new QuestionsT12("في الهيكل يوضع الكاس بداخل  .......", "كرسي الكاس", "صندوق الكاس", "كرتونة الكاس", 1);
        addQuestionT12(q10);
        QuestionsT12 q11 = new QuestionsT12("الملعقة تستخدم في تناول دم السيد المسيح  ولها اسم اخر هو ........", "الاستيك ", "المستير ", "المستر ", 2);
        addQuestionT12(q11);
        QuestionsT12 q12 = new QuestionsT12("......... هي زجاجة تستخدم لوضع الاباركه اثناء اختيار الحمل لحين صبه في الكاس", "كرسي الكاس", "درج البخور", "القارورة ", 3);
        addQuestionT12(q12);
        QuestionsT12 q13 = new QuestionsT12(".........يستخدم لوضع الجسد المقدس فيها اثناء التناول ", "الصينية ", "القبة", "البشارة ", 1);
        addQuestionT12(q13);
        QuestionsT12 q14 = new QuestionsT12("النجم او القبة توضع فوق ......", "كرسي الكاس", "الصينية ", "درج البخور", 2);
        addQuestionT12(q14);
        QuestionsT12 q15 = new QuestionsT12("البشارة عبارة عن علبة معدنية بداخلها ........ ", "الصليب ", "صورة للمسيح", "اجزاء من الانجيل ", 3);
        addQuestionT12(q15);
        QuestionsT12 q16 = new QuestionsT12("...... هو اناء من المعدن مخصص لوضع البخور", "درج البخور ", "كرسي البخور ", "المستير ", 1);
        addQuestionT12(q16);

        QuestionsT12 q17 = new QuestionsT12("من رموز الصليب  .......التي رفعها موسي حتي كل من نظر اليها شفي ", "الحية الذهبية", "الحية النحاسية", "الحية الفضية", 2);
        addQuestionT12(q17);
        QuestionsT12 q18 = new QuestionsT12("...... هو الصليب الذي يستخدمة الكاهن لتقديس القربان", "صليب الدورة", "صليب  الصدر", "صليب المذبح", 3);
        addQuestionT12(q18);
        QuestionsT12 q19 = new QuestionsT12("..........هو صليب كبير له يد طويلة ويستخدم في الدورات مثل دورة القيامة", "صليب الدورة", "صليب المذبح", "الحية الذهبية", 1);
        addQuestionT12(q19);
        QuestionsT12 q20 = new QuestionsT12("صليب الصدر هو الصليب الذي  يكون في سلسلة او خيط ويرتديه المؤمنين مفتخرين بالصليب ؟", "غلط", "صح", "........", 2);
        addQuestionT12(q20);
        QuestionsT12 q21 = new QuestionsT12("الشورية من رموز ......", "السيد المسيح", "الشهداء ", "العذراء مريم ", 3);
        addQuestionT12(q21);
        QuestionsT12 q22 = new QuestionsT12("........ هي اناء نحاسي او فضي او ذهبي علي شكل كوب يوضع فيه فحم ويحرق فيه", "الشورية ", "درج البخور", "الحية النحاسية ", 1);
        addQuestionT12(q22);

    }

    private void addQuestionT12(QuestionsT12 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT12, question.getQuestionT12());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T12, question.getOption1T12());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T12, question.getOption2T12());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T12, question.getOption3T12());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT12, question.getAnswerNrT12());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET12, null, cv);
    }

    public ArrayList<QuestionsT12> getAllQuestionsT12() {
        ArrayList<QuestionsT12> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET12, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT12 question = new QuestionsT12();
                question.setQuestionT12(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT12)));
                question.setOption1T12(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T12)));
                question.setOption2T12(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T12)));
                question.setOption3T12(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T12)));
                question.setAnswerNrT12(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT12)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    // T13
    private void fillQuestionsTableT13() {
        QuestionsT13 q1 = new QuestionsT13("تستخدم المراوح الليتورجية رمزا لحضور .......... حول المسيح", "البابا ", "السيرافيم ", "القديسين ", 1);
        addQuestionT13(q1);
        QuestionsT13 q2 = new QuestionsT13("يقف شماس  حاملا ........ امام الزخيرة عندما يخرج الكاهن من المذبح في التناول وفي رش المياه", "شمعة ", "صليب ", "شورية ", 2);
        addQuestionT13(q2);
        QuestionsT13 q3 = new QuestionsT13("إناء حفظ الزخيرة  يكون عباره عن علبة صغيره يكون بها الجسد مغموسا بالدم و يستخدم في ........"
               , "تناول المرضي غير القادرين  علي حضور القداس", "تناول المساجين غير القادرين  علي حضور القداس", "الاجابتين صح", 3);
        addQuestionT13(q3);
        QuestionsT13 q4 = new QuestionsT13("يوضع الشمعدان حول المذبح اشارة الي الملايكة في .......... ", "قبر السيد المسيح", "مزود  الميلاد", "السماء ", 1);
        addQuestionT13(q4);
        QuestionsT13 q5 = new QuestionsT13("الابريق والطشت يستخدمان في غسل يدي الكاهن اثناء القداس فقط ؟", "غلط", "صح", "......", 2);
        addQuestionT13(q5);
        QuestionsT13 q6 = new QuestionsT13("يستخدم زيت الميرون في ........و.......", "القنديل العام  و البصخه ", "التعميد و تطييب الاجساد", "التعميد والتدشين ", 3);
        addQuestionT13(q6);
        QuestionsT13 q7 = new QuestionsT13("لماذا يستخدم الدف و التريانتو ؟", "لضبط ايقاع الالحان الكنسية ", "لانه طقس تعلمناه من ايام المسيح", "لاظهار البراعه في استخدامهم ", 1);
        addQuestionT13(q7);
        QuestionsT13 q8 = new QuestionsT13("طبق الحمل يحتوي علي اعداد ...... من القربان", "زوجية ", "فردية ", "احادية ", 2);
        addQuestionT13(q8);

        QuestionsT13 q9 = new QuestionsT13("كلمة الايقونوستاز  يقصد بها :-", "تدشين الهيكل ", "الغطاء الثالث من اغطية المذبح", "حامل الايقونات", 3);
        addQuestionT13(q9);
        QuestionsT13 q10 = new QuestionsT13("لماذا تم وضع حامل الايقونات في الكنيسة ؟", "اعلان المصالحه التي تمت بين السماء والارض والاتصال بالكنيسة المنتصره في السماء ", "لتجميل شكل الكنيسة ", "لتذكر سير القديسين ", 1);
        addQuestionT13(q10);
        QuestionsT13 q11 = new QuestionsT13("بجانب ايقونه ربنا يسوع المسيح نجد ايقونة :-", "العذراء مريم ", "يوحنا المعمدان", "يوسف النجار", 2);
        addQuestionT13(q11);
        QuestionsT13 q12 = new QuestionsT13("تأتي ايقونة مارمرقس بعد ايقونة :-", "العذراء مريم", "يوحنا المعمدان", "الملاك ميخائيل", 3);
        addQuestionT13(q12);
        QuestionsT13 q13 = new QuestionsT13("نجد ايقونة العشاء الاخير :-", "اعلي الباب الملوكي", "علي يسار ايقونة يوحنا المعمدان", "علي يمين ايقونة الملاك ميخائيل", 1);
        addQuestionT13(q13);
        QuestionsT13 q14 = new QuestionsT13("ايقونة العشاء الاخير  يكون مرسوم فيها السيد المسيح مع ...... تلميذ", "13", "11", "12", 2);
        addQuestionT13(q14);
        QuestionsT13 q15 = new QuestionsT13("لقد واجهت الايقونات حربا شديدة  وكان هناك اشخاض ضد الايقونات :- ", "......", "غلط", "صح", 3);
        addQuestionT13(q15);
        QuestionsT13 q16 = new QuestionsT13("يقوم الاسقف بتدشين الايقونات بزيت :-", "الميرون ", "الزيتون ", "السمسم", 1);
        addQuestionT13(q16);

        QuestionsT13 q17 = new QuestionsT13("توضع قناديل امام كل الايقونات  ماعدا ايقونة :-", "السيدة العذراء مريم ", "السيد المسيح", "يوحنا المعمدان", 2);
        addQuestionT13(q17);
        QuestionsT13 q18 = new QuestionsT13("ترمز بيضه النعام  الي ...:-", "الصلب ", "المعمودية ", "القيامة ", 3);
        addQuestionT13(q18);
        QuestionsT13 q19 = new QuestionsT13("تقف الشمامسة في خورس المؤمنين ؟", "غلط", "صح ", ".......", 1);
        addQuestionT13(q19);
        QuestionsT13 q20 = new QuestionsT13("ترمز المنجلية الي ......:-", "العليقة ", "جبل سيناء عندما استلم موسي الشريعة", "جبل الزيتون حيث صعد المسيح الي السماء ", 2);
        addQuestionT13(q20);
        QuestionsT13 q21 = new QuestionsT13("تصلي الكنيسة  اللقان ... مرات في السنة", "5", "4", "3", 3);
        addQuestionT13(q21);
        QuestionsT13 q22 = new QuestionsT13("كان قديما يستخدم الانبل في :-", "العظات وقراءة فصول من الكتاب المقدس ", "تناول المرضي الغير قادرين علي حضور القداس", "تدشين الايقونات", 1);
        addQuestionT13(q22);
        QuestionsT13 q23 = new QuestionsT13("الاعمدة في الكنيسة تشير الي ......... :-", "الرسل ", "التلاميذ", "القديسين ", 2);
        addQuestionT13(q23);
        QuestionsT13 q24 = new QuestionsT13("يكون عدد القباب في الكنائس ...... أو..... أو.......:-", "1 - 4 - 6", "2 - 4 - 5 ", "1 - 3 - 5", 3);
        addQuestionT13(q24);

        QuestionsT13 q25 = new QuestionsT13("سر ........ هو باب الاسرار وبدونة  لا يمكنك ان تمارس اسرار الكنيسة", "المعمودية ", "التوبه و الإعتراف", "التناول ", 1);
        addQuestionT13(q25);
        QuestionsT13 q26 = new QuestionsT13("بيت القربان يسمي ايضا ....:-", "بيت إيل", "بيت لحم", "العلية ", 2);
        addQuestionT13(q26);
        QuestionsT13 q27 = new QuestionsT13("اثناء عمل القربان نقول  ....  سرا :-", "الانجيل كامل", "سفر التكوين", "المزامير ", 3);
        addQuestionT13(q27);

        QuestionsT13 q28 = new QuestionsT13("المنارة ترمز الي .....:-", "سارية فلك نوح الذي يرشد الناس الي الخلاص ", "سارية مركب بطرس عند اصطياد السمك", "ارتفاع مكانة الكنيسة الي السماء ", 1);
        addQuestionT13(q28);
        QuestionsT13 q29 = new QuestionsT13("تستخدم اجراس الكنيسة في الاعياد وفي الجنازات وعند حضور الاب الاسقف و بدأ القداس ؟", "......", "صح", "غلط", 2);
        addQuestionT13(q29);
        QuestionsT13 q30 = new QuestionsT13(
                " ما هي حجرة الدياكونية ؟", "مكان يصنع فيه القربان ", "مكان حيث تتقدم السيدات للتناول ", "غرفة لحفظ الأواني المقدسة وكتب الخدمة وملابس الكاهن ", 3);
        addQuestionT13(q30);

        QuestionsT13 q31 = new QuestionsT13("في سر المعمودية يقدس الكاهن الماء بشمعة علامة الي :-", "حلول الروح القدس", "الماء نظيفة ", "وجود الملائكة", 1);
        addQuestionT13(q31);
        QuestionsT13 q32 = new QuestionsT13("لماذا يتم اضاءة شمعتين  اثناء قراءة الانجيل  مع ان نور الشمس ينير الكنيسة ؟", "لانتباه الشعب الي الانجيل ", "للاشارة ان الانجيل هو نور العالم ونتذكر الاية  سراج لرجلي كلامك و نور لسبيلي", "لكي يري من يقرأ الانجيل   عند  انقطاع الكهرباء  ", 2);
        addQuestionT13(q32);
        QuestionsT13 q33 = new QuestionsT13("الزيت الساذج يستخدم في  .......:-", "سر مسحة المرضي ", "اخذ بركة من القديسين", "سر الزيجة", 3);
        addQuestionT13(q33);

        QuestionsT13 q34 = new QuestionsT13("زيت الغاليلاون يستخدم في ........:-", "سر المعمودية (بعد جحد الشيطان ) ", "سر المعمودية (قبل جحد الشيطان )", "سر الزيجة ", 1);
        addQuestionT13(q34);
        QuestionsT13 q35 = new QuestionsT13("زيت الميرون يستخدم في ....:-", "سر مسحة المرضي ", "تدشين الكنائس والمذابح", "سر المعمودية (قبل جحد الشيطان )", 2);
        addQuestionT13(q35);
        QuestionsT13 q36 = new QuestionsT13("زيت أبوغالمسيس يوضع اثناء قراءة سفر .... في ليلة ابوغالمسيس ثم يدهن به الكاهن الشعب", "اعمال الرسل", "اشعياء ", "الرؤيا ", 3);
        addQuestionT13(q36);

        QuestionsT13 q37 = new QuestionsT13(
                " زيت مسحة المرضى يسمي ايضا صلاة القنديل لان الصلاة تتم في طبق زيت وبة ...... قناديل", "7", "5", "3", 1);
        addQuestionT13(q37);
        QuestionsT13 q38 = new QuestionsT13("تمارس الكنيسة سر مسحة المرضي مرة واحدة كل عام في ........ :-", "الجمعة العظيمة ", "جمعة ختام الصوم", "عيد حلول الروح القدس", 2);
        addQuestionT13(q38);
        QuestionsT13 q39 = new QuestionsT13("زيت القديسين والحنوط يستخدم في سر مسحة المرضي ....", "......", "صح", "غلط", 3);
        addQuestionT13(q39);
    }

    private void addQuestionT13(QuestionsT13 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT13, question.getQuestionT13());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T13, question.getOption1T13());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T13, question.getOption2T13());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T13, question.getOption3T13());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT13, question.getAnswerNrT13());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET13, null, cv);
    }

    public ArrayList<QuestionsT13> getAllQuestionsT13() {
        ArrayList<QuestionsT13> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET13, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT13 question = new QuestionsT13();
                question.setQuestionT13(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT13)));
                question.setOption1T13(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T13)));
                question.setOption2T13(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T13)));
                question.setOption3T13(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T13)));
                question.setAnswerNrT13(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT13)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    //C11
    private void fillQuestionsTableC11() {
        QuestionsC11 q1 = new QuestionsC11("ايه الحروف المتحركة؟", "تنطق  أ - و - ي", "تنطق أ - ن - س ", "تنطق  و - ي - م ", 1);
        addQuestionC11(q1);
        QuestionsC11 q2 = new QuestionsC11(" اية الحروف المتحركة للكسر ؟", "B - J - L", "E - 3 - I", "A - W - O", 2);
        addQuestionC11(q2);
        QuestionsC11 q3 = new QuestionsC11("كلمة مجد تعني .....", "Elkl3cia إكليسيا", "I3covc  إيسوس", "Wov أوأوو", 3);
        addQuestionC11(q3);
        QuestionsC11 q4 = new QuestionsC11("حرف الابسلن   v   ينطق:-", "ف - و - ي", "خ - ك - ي", "ج - ن - غ", 1);
        addQuestionC11(q4);
        QuestionsC11 q5 = new QuestionsC11("حرف الايتا 3 ينطق :-", "ت", "ي", "أ", 2);
        addQuestionC11(q5);
        QuestionsC11 q6 = new QuestionsC11("حرف الكبا K ينطق :-", "ك", "م", "ب", 1);
        addQuestionC11(q6);
        QuestionsC11 q7 = new QuestionsC11("حرف الني N ينطق :-", "ي", "ن", "م", 2);
        addQuestionC11(q7);
        QuestionsC11 q8 = new QuestionsC11("حرف L يسمي :-", "كي", "مي", "لولا ", 3);
        addQuestionC11(q8);
        QuestionsC11 q9 = new QuestionsC11("حرف T يسمي:-", "تاف ", "تي", "لولا  ", 1);
        addQuestionC11(q9);
        QuestionsC11 q10 = new QuestionsC11("كلمة ÷إكليسيا  Elkl3cia  تعني :-", "خبز", "كنيسة ", "انجيل ", 2);
        addQuestionC11(q10);
        QuestionsC11 q11 = new QuestionsC11("كلمة يسوع تعني :- ", "112ovri شوري", "Erfei إيرفي ", "I3covc  إيسوس", 3);
        addQuestionC11(q11);
        QuestionsC11 q12 = new QuestionsC11("كلمة  باندوكراتور   Pantokratwr تعني:- ", "ضابط الكل ", "المخلص ", "كاهن ", 1);
        addQuestionC11(q12);
        QuestionsC11 q13 = new QuestionsC11("كلمة  يوت Iwt تعني :-", "مجد ", "أب ", "صليب ", 2);
        addQuestionC11(q13);

    }

    private void addQuestionC11(QuestionsC11 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC11, question.getQuestionC11());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C11, question.getOption1C11());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C11, question.getOption2C11());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C11, question.getOption3C11());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC11, question.getAnswerNrC11());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC11, null, cv);
    }

    public ArrayList<QuestionsC11> getAllQuestionsC11() {
        ArrayList<QuestionsC11> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC11, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC11 question = new QuestionsC11();
                question.setQuestionC11(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC11)));
                question.setOption1C11(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C11)));
                question.setOption2C11(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C11)));
                question.setOption3C11(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C11)));
                question.setAnswerNrC11(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC11)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // C12
    private void fillQuestionsTableC12() {
        QuestionsC12 q1 = new QuestionsC12("حرف البيتا B ينطق :-", "ب - ف", "ب - ي", "ج - چ", 1);
        addQuestionC12(q1);
        QuestionsC12 q2 = new QuestionsC12("ينطق حرف البيتا B ف لوجود :-", "قبله حرف متحرك ", "بعده حرف متحرك ", "بعده حرف متحرك للكسر ", 2);
        addQuestionC12(q2);
        QuestionsC12 q3 = new QuestionsC12("الحرف R يسمي  :-", "فاي", "الفا", "رو", 3);
        addQuestionC12(q3);
        QuestionsC12 q4 = new QuestionsC12("حرف الرو  R ينطق  :-", "ر", "و", "م", 1);
        addQuestionC12(q4);
        QuestionsC12 q5 = new QuestionsC12("حرف  m يسمي  :-", "ني", "مي", "سيما ", 2);
        addQuestionC12(q5);
        QuestionsC12 q6 = new QuestionsC12("كلمة كاهن تعني  :- ", "Ctav,roc ستافروس", "Wov أوأوو", "Ov83b أوويب", 3);
        addQuestionC12(q6);
        QuestionsC12 q7 = new QuestionsC12("كلمة  Mvron تعني  :- ", "الميرون ", "مريم ", "الاله ", 1);
        addQuestionC12(q7);
        QuestionsC12 q8 = new QuestionsC12("كلمة اسم  تعني  :-", "Fnovt أفنوتي", "Ra,n ران", "Agp أجب", 2);
        addQuestionC12(q8);

        QuestionsC12 q9 = new QuestionsC12("كلمة صليب  تعني  :-", ")r3r إثرير", "Car7 ساركس", "Ctavroc ستافروس", 3);
        addQuestionC12(q9);
        QuestionsC12 q10 = new QuestionsC12("حرف @ يسمي  :-", "شاي", "مي", "خاي", 1);
        addQuestionC12(q10);
        QuestionsC12 q11 = new QuestionsC12("حرف ) يسمي :-", "سيما", "ثيتا ", "إيتا ", 2);
        addQuestionC12(q11);
        QuestionsC12 q12 = new QuestionsC12("حرف ) ينطق  :-", "ث - أ", "ث -  ي", "ث  - ت", 3);
        addQuestionC12(q12);
        QuestionsC12 q13 = new QuestionsC12("الحرف P يسمي :-", "بي", "تاف", "ابسي", 1);
        addQuestionC12(q13);
        QuestionsC12 q14 = new QuestionsC12("شكل حرف ال في  :-", "Y", "F", "$", 2);
        addQuestionC12(q14);
        QuestionsC12 q15 = new QuestionsC12("كلمة سماء يعني :-", "Motria ماريا", "Gom جوم", "Tfe إتفيه", 3);
        addQuestionC12(q15);
        QuestionsC12 q16 = new QuestionsC12("كلمة ابنة تعني  :-", "@eri ", "@ere", "@3ri", 1);
        addQuestionC12(q16);

        QuestionsC12 q17 = new QuestionsC12("كلمة  @3ri تعني :-", "ابنه", "ابن ", "السلام", 2);
        addQuestionC12(q17);
        QuestionsC12 q18 = new QuestionsC12("كلمة عذراء تعني  :-", "E0necwc إثنيسوس", "Maria  ماريا", "Par0enoc بارثينوس ", 3);
        addQuestionC12(q18);
        QuestionsC12 q19 = new QuestionsC12("حرف $ يسمي  :-", "فاي", "في", "هوري", 1);
        addQuestionC12(q19);
        QuestionsC12 q20 = new QuestionsC12("حرف T تي ينطق :-", "ت", "تي", "ي", 2);
        addQuestionC12(q20);
        QuestionsC12 q21 = new QuestionsC12("حرف G يسمي :-", "لولا", "دلتا", "جنجا ", 3);
        addQuestionC12(q21);
        QuestionsC12 q22 = new QuestionsC12("حرف  G ينطق :-", "ج - چ", "ن", "ج", 1);
        addQuestionC12(q22);
        QuestionsC12 q23 = new QuestionsC12("حرف X ينطق :-", "ك - ن - ي", "ش - خ - ك", "ك - ي", 2);
        addQuestionC12(q23);
        QuestionsC12 q24 = new QuestionsC12("حرف X يسمي :-", "ني", "كبا ", "كي", 3);
        addQuestionC12(q24);

        QuestionsC12 q25 = new QuestionsC12("كلمة عبور تعني :-", "Lol  لول", "Afot افنوت", "Pacxa باصخا ", 3);
        addQuestionC12(q25);
        QuestionsC12 q26 = new QuestionsC12("كلمة )_ok ثوك تعني :-", "قوه", "مجد", "لك", 3);
        addQuestionC12(q26);
        QuestionsC12 q27 = new QuestionsC12("كلمة Fnovt افنوتي  تعني :-", "الاب ", "يسوع ", "الله ", 3);
        addQuestionC12(q27);
        QuestionsC12 q28 = new QuestionsC12("كلمة ساعة تعني :-", "18qen خين ", "Fai فاي", "Agp أجب", 3);
        addQuestionC12(q28);




    }

    private void addQuestionC12(QuestionsC12 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC12, question.getQuestionC12());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C12, question.getOption1C12());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C12, question.getOption2C12());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C12, question.getOption3C12());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC12, question.getAnswerNrC12());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC12, null, cv);
    }

    public ArrayList<QuestionsC12> getAllQuestionsC12() {
        ArrayList<QuestionsC12> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC12, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC12 question = new QuestionsC12();
                question.setQuestionC12(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC12)));
                question.setOption1C12(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C12)));
                question.setOption2C12(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C12)));
                question.setOption3C12(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C12)));
                question.setAnswerNrC12(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC12)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // C13
    private void fillQuestionsTableC13() {
        QuestionsC13 q1 = new QuestionsC13("حرف S يسمي :-", "تشيما ", "هوري", "سو", 1);
        addQuestionC13(q1);
        QuestionsC13 q2 = new QuestionsC13("حرف ابسي Y ينطق  :-", "ب", "بس", "أ", 2);
        addQuestionC13(q2);
        QuestionsC13 q3 = new QuestionsC13("حرف H يسمي ....... وينطق ........ :-", "فاي - ف", "تشيما  -تش", "هوري - هـ", 3);
        addQuestionC13(q3);
        QuestionsC13 q4 = new QuestionsC13("حرف D يسمي .... وينطق ..... :-", "دلتا - د - ذ", "دلتا - د", "لولا - ل ", 1);
        addQuestionC13(q4);
        QuestionsC13 q5 = new QuestionsC13("قداس  يعني :-", "Erfei ايرفي ", "An<>=afora انافورا ", "P=acxa باصخا ", 2);
        addQuestionC13(q5);
        QuestionsC13 q6 = new QuestionsC13("كلمة هيب Hi3b تعني :-", "حمل ", "قداس ", "مزمور", 1);
        addQuestionC13(q6);
        QuestionsC13 q7 = new QuestionsC13("كلمة Tsrompi تعني  :-", "الحمامة ", "الجنة ", "سلام ", 2);
        addQuestionC13(q7);
        QuestionsC13 q8 = new QuestionsC13("كلمة بخور تعني : -", "Pencaq بين ساخ ", "Hi3b هييب ", "C90oinov4i استوي نوفي ", 3);
        addQuestionC13(q8);

        QuestionsC13 q9 = new QuestionsC13("كلمة @ovri شوري تعني :- ", "شورية ", "شعب ", "حمامة ", 1);
        addQuestionC13(q9);
        QuestionsC13 q10 = new QuestionsC13("كلمة Yalmoc تعني :-", "ابصالية ", "مزمور ", "ذكصولوجية ", 2);
        addQuestionC13(q10);
        QuestionsC13 q11 = new QuestionsC13("كلمة   Xereشيري تعني   :-", "انسان ", "ابنه ", "السلام ", 3);
        addQuestionC13(q11);
        QuestionsC13 q12 = new QuestionsC13("كلمة شماس  تعني  :-", "Diakwn ذياكون", "Pavloc بافلوس", "Ekkl3cia اكليسيا ", 1);
        addQuestionC13(q12);
        QuestionsC13 q13 = new QuestionsC13("حرف 8& يسمي ..... وينطق ...... :-", "زيتا - ز", "إكسي - كس", "سو - سو ", 2);
        addQuestionC13(q13);
        QuestionsC13 q14 = new QuestionsC13("حرف ^ يسمي :-", "سو", "غما ", "زيتا", 1);
        addQuestionC13(q14);
        QuestionsC13 q15 = new QuestionsC13("حرف J يسمي  .......وينطق .........  :-", "غما - ج ن خ ", "غما - ج ن غ", "غما - غ", 2);
        addQuestionC13(q15);
        QuestionsC13 q16 = new QuestionsC13("حرف الغما J ينطق ن عندما  :-", " يأتي قبلة حرف حلقي ", "يأتي بعده حرف متحرك للكسر ", "يأتي بعده حرف حلقي ", 3);
        addQuestionC13(q16);

        QuestionsC13 q17 = new QuestionsC13("كلمة ملاك  تعني :-", "AJJELOC انجيلوس ", "Pavloc  بافلوس ", "E0necwc  اثنيسوس", 1);
        addQuestionC13(q17);
        QuestionsC13 q18 = new QuestionsC13("كلمة Car7 ساركس تعني :- ", "دم ", "جسد", "تناول ", 2);
        addQuestionC13(q18);
        QuestionsC13 q19 = new QuestionsC13("كلمة Pensoic بين تشويس  يعني :- ", "يسوع ", "الله", "ربنا ", 3);
        addQuestionC13(q19);
        QuestionsC13 q20 = new QuestionsC13("كلمة صينية تعني :-", ")r3r اثرير ", "Tfe اتفيه", "Afot انوت ", 1);
        addQuestionC13(q20);

    }

    private void addQuestionC13(QuestionsC13 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC13, question.getQuestionC13());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C13, question.getOption1C13());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C13, question.getOption2C13());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C13, question.getOption3C13());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC13, question.getAnswerNrC13());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC13, null, cv);
    }

    public ArrayList<QuestionsC13> getAllQuestionsC13() {
        ArrayList<QuestionsC13> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC13, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC13 question = new QuestionsC13();
                question.setQuestionC13(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC13)));
                question.setOption1C13(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C13)));
                question.setOption2C13(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C13)));
                question.setOption3C13(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C13)));
                question.setAnswerNrC13(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC13)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

////////////////////////////////////////////////////////////////////////
    //T21
    private void fillQuestionsTableT21() {
        QuestionsT21 q1 = new QuestionsT21("كم عدد اسرار الكنيسة ؟", "7", "5", "3", 1);
        addQuestionT21(q1);
        QuestionsT21 q2 = new QuestionsT21("السر الكنسي يمكن ان يقوم به اي شخص ولا يشترط وجود كاهن ؟", "صح ", "غلط ", ".......", 2);
        addQuestionT21(q2);
        QuestionsT21 q3 = new QuestionsT21("في المعمودية يولد الانسان ولادة ثانية من فوق .....", "بالماء ", "بالروح ", "بالماء والروح ", 3);
        addQuestionT21(q3);
        QuestionsT21 q4 = new QuestionsT21("بالميرون ننال نعمة حلول ........ لتثبيتنا في الحياة الروحية ", "الروح القدس", "البركة ", "الكلمة ", 1);
        addQuestionT21(q4);
        QuestionsT21 q5 = new QuestionsT21("ما هو اول الاسرار وهو باب يدخل منة المؤمن الي الكنيسة ؟", "سر الزيجة ", "سر المعمودية ", "سر الاعتراف ", 2);
        addQuestionT21(q5);
        QuestionsT21 q6 = new QuestionsT21("ان كان احد لا يولد من الماء والروح لايقدر ان يدخل ......(يو 3 : 5)", "السماء ", "الكنيسة ", "ملكوت الله ", 3);
        addQuestionT21(q6);
        QuestionsT21 q7 = new QuestionsT21("جرن المعمودية هو .... التي تلدنا حتي نصير ابناء الله ", "بطن الكنيسة ", "حضن الكنيسة ", "قلب الكنيسة ", 1);
        addQuestionT21(q7);
        QuestionsT21 q8 = new QuestionsT21("من رموز المعمودية في العهد القديم ..... و..... ", " تقدمة اسحاق  و الطوفان ", "الطوفان وعبور البحر الاحمر ", "عبور البحر الاحمر و الضربات العشرة ", 2);
        addQuestionT21(q8);
        QuestionsT21 q9 = new QuestionsT21("من الذي اسس سر المعمودية ؟", "يوحنا المعمدان ", "بطرس الرسول ", "يسوع المسيح ", 3);
        addQuestionT21(q9);

        QuestionsT21 q10 = new QuestionsT21("من امن واعتمد خلص ومن لم يؤمن ..... (مر16 : 16)", "يدن ", "يمت ", "ينقطع عن شركة الكنيسة ", 1);
        addQuestionT21(q10);
        QuestionsT21 q11 = new QuestionsT21("في صلوات جحد الشيطان في سر المعمودية يدهن الكاهن الطفل بزيت ....", "الميرون ", "الساذج ", "الزيتون ", 2);
        addQuestionT21(q11);
        QuestionsT21 q12 = new QuestionsT21("يغطس الكاهن الطفل في ماء المعمودية ..... مرات ", "5", "4", "3", 3);
        addQuestionT21(q12);
        QuestionsT21 q13 = new QuestionsT21("يسمي سر الميرون ايضا بسر .....", "التثبيت ", "المعمودية ", "مسحة المرضي ", 1);
        addQuestionT21(q13);
        QuestionsT21 q14 = new QuestionsT21("اول من عمل سر الميرون .....", "يسوع المسيح", "التلاميذ ", "مارمرقس الرسول ", 2);
        addQuestionT21(q14);
        QuestionsT21 q15 = new QuestionsT21("يرشم الكاهن الطفل في سر الميرون ..... رشمة في كل اعضاء جسده", "38", "37", "36", 3);
        addQuestionT21(q15);
        QuestionsT21 q16 = new QuestionsT21("في سر الميرون يرشم الكاهن رأس الطفل المعمد  علي شكل صليب ..... رشومات ", "8", "7", "6", 1);
        addQuestionT21(q16);
        QuestionsT21 q17 = new QuestionsT21("في سر الميرون يرشم الكاهن الرجل الواحدة للطفل المعمد  ..... رشومات ", "7", "6", "5", 2);
        addQuestionT21(q17);
        QuestionsT21 q18 = new QuestionsT21("في سر الميرون يرشم الكاهن  اليد الواحدة للطفل المعمد  ..... رشومات ", "8", "7", "6", 3);
        addQuestionT21(q18);

    }

    private void addQuestionT21(QuestionsT21 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT21, question.getQuestionT21());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T21, question.getOption1T21());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T21, question.getOption2T21());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T21, question.getOption3T21());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT21, question.getAnswerNrT21());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET21, null, cv);
    }

    public ArrayList<QuestionsT21> getAllQuestionsT21() {
        ArrayList<QuestionsT21> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET21, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT21 question = new QuestionsT21();
                question.setQuestionT21(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT21)));
                question.setOption1T21(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T21)));
                question.setOption2T21(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T21)));
                question.setOption3T21(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T21)));
                question.setAnswerNrT21(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT21)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    // T22
    private void fillQuestionsTableT22() {
        QuestionsT22 q1 = new QuestionsT22("ما هو سر الاسرار ؟", "سر الافخارستية ", "سر المعمودية ", "سر الكهنوت  ", 1);
        addQuestionT22(q1);
        QuestionsT22 q2 = new QuestionsT22("من رموز الافخارستية في العقهد القديم .....و.....و....", "خروف الفصح والمن السماوي و معجزة اشباع الجموع ", "تقدمة ملكيصادق و المن السماوي وخروف الفصح ", "تقدمة ملكيصادق و المن السماوي و العليقة ", 2);
        addQuestionT22(q2);
        QuestionsT22 q3 = new QuestionsT22("من الذي اسس سر الافخارستية ؟", "التلاميذ ", "يوحنا المعمدان ", "الرب يسوع ", 3);
        addQuestionT22(q3);
        QuestionsT22 q4 = new QuestionsT22("من يأكل جسدي ويشرب دمي ..... وانا اقيمة في اليوم الاخير (يو6 :54)", "فلة حياة ابدية  ", "يثبت فيا وانا فية ", "يعيش الي الابد ", 1);
        addQuestionT22(q4);
        QuestionsT22 q5 = new QuestionsT22("سر .... هو سر يرجع بة الخاطئ الي الله باعترافه بخطاياة الي الاب الكاهن", "الزيجة ", "التوبة والاعتراف ", "الكهنوت ", 2);
        addQuestionT22(q5);
        QuestionsT22 q6 = new QuestionsT22("من رموز سر التوية والاعتراف في العهد القديم ......", "كانت الناس تقديم الذبيحة وتعترف  عن خطاياهم  ", "كانت الناس تعتمد معمودية يوحنا ويعترفوا عن خطاياهم ", "الاجابتين صح ", 3);
        addQuestionT22(q6);
        QuestionsT22 q7 = new QuestionsT22("يجب الاهتمام بمحاسبة النفس وخصوصا قبل الاعتراف ؟", "صح ", "غلط", "......", 1);
        addQuestionT22(q7);
        QuestionsT22 q8 = new QuestionsT22("الاعتراف هو سرد الاخطاء فقط ؟", "صح", "غلط", "........", 2);
        addQuestionT22(q8);
        QuestionsT22 q9 = new QuestionsT22("سر القنديل هو سر ....", "الزيجة ", "الميرون ", "مسحة المرضي ", 3);
        addQuestionT22(q9);


        QuestionsT22 q10 = new QuestionsT22("في سر مسحة المرضي يستم الصلاه في طبق زيت بة ..... فتائل من القطن ", "7", "6", "5", 1);
        addQuestionT22(q10);
        QuestionsT22 q11 = new QuestionsT22("من الذي اسس سر مسحة المرضي ؟", "يوحنا المعمدان ", "المسيح", "التلاميذ ", 2);
        addQuestionT22(q11);
        QuestionsT22 q12 = new QuestionsT22("في سر مسحة المرضي يتم فية شفاء ...", "جسدي فقط ", "روحي فقط ", "جسدي وروحي ", 3);
        addQuestionT22(q12);
        QuestionsT22 q13 = new QuestionsT22("في سر مسحة المرضي يجب ان يكون الكاهن والحاضرين صائمين .؟", "صح", "غلط ", "......", 1);
        addQuestionT22(q13);
        QuestionsT22 q14 = new QuestionsT22("في سر مسحة المرضي يدهن الكاهن زيت مسحة المرضي ل", "لكل الحاضرين ", "للمريض فقط ", "لا يوجد مسح بالزيت في هذا السر", 2);
        addQuestionT22(q14);
        QuestionsT22 q15 = new QuestionsT22("عنما يكون  واحد من البيت مريض فنحن ......", "نحضر الطبيب لة  فقط", "نحضر الكاهن ليقوم بسر مسحة المرضة فقط", "نحضر الطبيب لة  و نحضر الكاهن ليقوم بسر مسحة المرضة ", 3);
        addQuestionT22(q15);




    }

    private void addQuestionT22(QuestionsT22 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT22, question.getQuestionT22());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T22, question.getOption1T22());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T22, question.getOption2T22());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T22, question.getOption3T22());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT22, question.getAnswerNrT22());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET22, null, cv);
    }

    public ArrayList<QuestionsT22> getAllQuestionsT22() {
        ArrayList<QuestionsT22> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET22, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT22 question = new QuestionsT22();
                question.setQuestionT22(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT22)));
                question.setOption1T22(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T22)));
                question.setOption2T22(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T22)));
                question.setOption3T22(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T22)));
                question.setAnswerNrT22(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT22)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    // T23
    private void fillQuestionsTableT23() {
        QuestionsT23 q1 = new QuestionsT23("اذ ليسا بعد اثنان بل جسدا واحدا فالذي جمعة الله ..... (مت19 :6)", "لا يفرقة انسان ", "لا يفرقة الله ", "يفرقة انسان ", 1);
        addQuestionT23(q1);
        QuestionsT23 q2 = new QuestionsT23("سر الزيجة مكون من طقس واحد فقط وهو الاكليل المقدس ؟", "صح ", "غلط", ".....", 2);
        addQuestionT23(q2);
        QuestionsT23 q3 = new QuestionsT23("في سر الزيجة في طقس الخطبة ....", "يلبس الكاهن الدبلة للخطيبة ", "يلبس الخطيب الدبلة للكاهن ", "يلبس الخطيب الدبلة لخطيبتة ", 3);
        addQuestionT23(q3);
        QuestionsT23 q4 = new QuestionsT23("في سر الزيجة في طقس  عربون الزواج ....", "الكاهن يلبس العروسين الدبلتين", "العروسين هم من يلبسوا الدبلتين ", "لا يوجد تلبيس دبل في هذا الطقس", 1);
        addQuestionT23(q4);
        QuestionsT23 q5 = new QuestionsT23("قديما كان يذهب العروسين للدير بعد الاكليل لمدة ...ايام ", "5", "3", "10", 2);
        addQuestionT23(q5);
        QuestionsT23 q6 = new QuestionsT23("في سر الزيجة في طقس الاكليل ", "يتم وضع الاكليل", "مسح العروسين بالزيت ", "الاجابتين صح", 3);
        addQuestionT23(q6);
        QuestionsT23 q7 = new QuestionsT23("من الذي اسس سر الكهنوت ؟", "الرب يسوع ", "الرسل ", "يوحنا المعمدان ", 1);
        addQuestionT23(q7);
        QuestionsT23 q8 = new QuestionsT23("ما معني كلمة شماس ؟", "كاهن ", "خادم ", "معلم ", 2);
        addQuestionT23(q8);
        QuestionsT23 q9 = new QuestionsT23("ما معني كلمة ابصالتيس ؟", "قارىء", "شماس ", "مرتل ", 3);
        addQuestionT23(q9);

        QuestionsT23 q10 = new QuestionsT23("ما معني كلمة اغنسطس .؟", "قارىء", "شماس ", "مرتل", 1);
        addQuestionT23(q10);
        QuestionsT23 q11 = new QuestionsT23("ما معني كلمة ايبودياكون ؟", "رئيس الشمامسة", "مساعد الدياكون ", "شماس ", 2);
        addQuestionT23(q11);
        QuestionsT23 q12 = new QuestionsT23("ما معني كلمة دياكون ؟", "رئيس الشمامسة ", "مرتل  ", "شماس", 3);
        addQuestionT23(q12);
        QuestionsT23 q13 = new QuestionsT23("ما معني كلمة ارشيدياكون؟", "رئيس الشمامسة ", "مساعد الدياكون ", "شماس ", 1);
        addQuestionT23(q13);
        QuestionsT23 q14 = new QuestionsT23("من مهام ال....  رعاية الفقراء والارامل وخدمة الشعب", "ايبودياكون ", "دياكون ", "اغنسطس ", 2);
        addQuestionT23(q14);
        QuestionsT23 q15 = new QuestionsT23("كان القديس اسطفانوس .....", "دياكون ", "ايبودياكون ", "ارشيدياكون", 3);
        addQuestionT23(q15);
        QuestionsT23 q16 = new QuestionsT23("......هو رداء ابيض من الكتان تلبسة الشمامسة ", "التونية ", "البطرشيل ", "الطيلسانة ", 1);
        addQuestionT23(q16);
        QuestionsT23 q17 = new QuestionsT23("..... هو وشاح من القماش المزين بالصلبان يلبسة الشمامسة فوق التونية ", "الصدرة ", "البطرشيل ", "الطيلسانة ", 2);
        addQuestionT23(q17);
        QuestionsT23 q18 = new QuestionsT23("ما معني كلمة بريسفيتيروس ؟", "قائد وهو رتبة القمص", "الناظر  وهو اعلي درجة كهنوت في الكنيسة", "شفيع وهو رتبة القس ", 3);
        addQuestionT23(q18);

        QuestionsT23 q19 = new QuestionsT23("ما معني كلمة ايغومانوس؟", "قائد وهو رتبة القمص", "الناظر  وهو اعلي درجة كهنوت في الكنيسة", "شفيع وهو رتبة القس", 1);
        addQuestionT23(q19);
        QuestionsT23 q20 = new QuestionsT23("ما معني كلمة الاسقف؟", "قائد وهو رتبة القمص", "الناظر  وهو اعلي درجة كهنوت في الكنيسة ", "شفيع وهو رتبة القس", 2);
        addQuestionT23(q20);
        QuestionsT23 q21 = new QuestionsT23("من هو الابيسكوبوس؟", "هو الاسقف", "هو القمص ", "هو مساعد الاسقف ", 3);
        addQuestionT23(q21);
        QuestionsT23 q22 = new QuestionsT23("المطران هو ....", "اسقف لاكثر من مدينة او مدينة كبيره", "اسقف مدينة صغيرة ", "اسقف مدينة مجهولة ", 1);
        addQuestionT23(q22);
        QuestionsT23 q23 = new QuestionsT23("أرشي إبيسكوبوس تعني....", "اسقف ", "رئيس الاساقفة ", "مطران ", 2);
        addQuestionT23(q23);
        QuestionsT23 q24 = new QuestionsT23("ما معني كلمة بطريرك؟", "رئيس الاباء ", "اب شعب ", "كلا الاجابتين صحيح ", 3);
        addQuestionT23(q24);
        QuestionsT23 q25 = new QuestionsT23("..... هي طاقية مرتفعة مزينة بصلبان يلبسها الكاهن ", "طيلسانة ", "شملة ", "صدرة ", 1);
        addQuestionT23(q25);
        QuestionsT23 q26 = new QuestionsT23("لبس الكاهن .... فوق التونية في خدمة القداس  ", "طيلسانة ", "صدرة ", "برنس", 2);
        addQuestionT23(q26);
        QuestionsT23 q27 = new QuestionsT23("......من الحرير الأبيض المغزول والمحلي بالذهب وا لأحجار الكريمة ويعلوه صليب فوقه ويزين أيضاً بالصلبان و صورة رب المجد  ", "عمة", "القلسوة", "التاج ", 3);
        addQuestionT23(q27);
        QuestionsT23 q28 = new QuestionsT23("الابصلمودية المقدسة هو ....", "كتاب التسبحة اليومية وكتاب التسبحة الكيهكية", "كتاب صلوات السواعي ", "كتاب يحتوي علي التمجيدات ", 1);
        addQuestionT23(q28);
        QuestionsT23 q29 = new QuestionsT23("الاجبية هو ...... ", "هو الكتاب الذي يحوي فصول القراءات التي تقال في القداس علي مدار السنة", "كتاب صلوات السواعي ", "هو كتاب يحوي سيرة مختصرة لشهداء الكنيسة", 2);
        addQuestionT23(q29);
        QuestionsT23 q30 = new QuestionsT23("الخولاجي هو ...", "كتاب صلوات السواعي ", "هو كتاب يحوي سيرة مختصرة لشهداء الكنيسة", "الكتاب الذي يحوي نصوص صلوات القداسات القبطية الثلاثية", 3);
        addQuestionT23(q30);
        QuestionsT23 q31 = new QuestionsT23("الدفنار هو .....", "كتاب يحتوي علي سرد داريخي مختصر في أسلوب تماجيد و تطويات للأعياد السيدية", "كتاب التسبحة اليومية وكتاب التسبحة الكيهكية", "كتاب صلوات السواعي ", 1);
        addQuestionT23(q31);
        QuestionsT23 q32 = new QuestionsT23("دلال هو ....", "كتاب صلوات السواعي ", "هو الكتاب الذي يرشد إلى طريقة الصلاة في الأعياد والمناسبات", "كتاب التسبحة اليومية وكتاب التسبحة الكيهكية", 2);
        addQuestionT23(q32);
        QuestionsT23 q33 = new QuestionsT23("سنكسار هو .....", "هو الكتاب الذي يرشد إلى طريقة الصلاة في الأعياد والمناسبات", "كتاب التسبحة اليومية وكتاب التسبحة الكيهكية", "كتاب يحوي سيرة مختصرة لشهداء الكنيسة و قديسيها وكذلك أعيادها علي مدار السنة القبطية", 3);
        addQuestionT23(q33);
        QuestionsT23 q34 = new QuestionsT23("ما هو الكتاب الذي يحو فصول القراءات التي تقال في القداس علي مدار السنة؟", "القطمارس ", "السنكسار ", "الدفنار ", 1);
        addQuestionT23(q34);
        QuestionsT23 q35 = new QuestionsT23("يجب استخدام التليفون بداخل الكنيسة ؟", "صح", "غلط", "......", 2);
        addQuestionT23(q35);
        QuestionsT23 q36 = new QuestionsT23("وانت رايح الكنيسة بتقول اية ؟", "فرحت بالقائلين لي إلى بيت الرب نذهب", "الساكن في ستر العلي يستريح", "الاجابتين صحيحتان ", 3);
        addQuestionT23(q36);
        QuestionsT23 q37 = new QuestionsT23("في فترة عيد الميلاد الي الختان نصلي بانغمة  .....", "الفرايحي ", "الشعانيني ", "الصيامي ", 1);
        addQuestionT23(q37);
        QuestionsT23 q38 = new QuestionsT23("جميع الاعياد السيدية نصلي بالنغمة ......", "السنوي", "الفرايحي ", "الحزايني ", 2);
        addQuestionT23(q38);
        QuestionsT23 q39 = new QuestionsT23("في عيد الصليب نصلي بالنغمة .....", "الفرايحي ", "السنوي ", "الشعانيني الفرايحي ", 3);
        addQuestionT23(q39);
        QuestionsT23 q40 = new QuestionsT23("خلال شهر كيهك نصلي بالنغمة .....", "الكيهكي", "الفرايحي ", "السنوي ", 1);
        addQuestionT23(q40);
        QuestionsT23 q41 = new QuestionsT23("في صوم نينوي نصلي بنغمة .....", "السنوي ", "الصيامي ", "الشعانيني ", 2);
        addQuestionT23(q41);
        QuestionsT23 q42 = new QuestionsT23("في صلوات البصخة نصلي بالنغمة .....", "السنوي ", "الصيامي ", "الحزايني", 3);
        addQuestionT23(q42);

    }

    private void addQuestionT23(QuestionsT23 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT23, question.getQuestionT23());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T23, question.getOption1T23());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T23, question.getOption2T23());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T23, question.getOption3T23());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT23, question.getAnswerNrT23());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET23, null, cv);
    }

    public ArrayList<QuestionsT23> getAllQuestionsT23() {
        ArrayList<QuestionsT23> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET23, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT23 question = new QuestionsT23();
                question.setQuestionT23(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT23)));
                question.setOption1T23(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T23)));
                question.setOption2T23(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T23)));
                question.setOption3T23(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T23)));
                question.setAnswerNrT23(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT23)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    //C21
    private void fillQuestionsTableC21() {
        QuestionsC21 q1 = new QuestionsC21("الحروف المتحركة هي التي تنطق ؟", "أ - ي - ن ", "أ - و - ي", "ي - ن -م", 1);
        addQuestionC21(q1);
        QuestionsC21 q2 = new QuestionsC21("الحروف المتحركة التي تنطق  ي تسمي :-", "حروف متحركة للفتح ", "حروف متحركة للكسر ", "حروف متحركة للضم ", 2);
        addQuestionC21(q2);
        QuestionsC21 q3 = new QuestionsC21("حرف B يسمي ...... وينطق ..... :-", "الفا -أ", "بيتا - ي", "بيتا - ب ", 3);
        addQuestionC21(q3);
        QuestionsC21 q4 = new QuestionsC21("حرف الغما J ينطق :- ", "ج - ن - غ ", "غ - ج - م", "غ - م - أ", 1);
        addQuestionC21(q4);
        QuestionsC21 q5 = new QuestionsC21("حرف الدلتا ينطق د عندما :- ", "يأتي بعدة حرف متحرك ", "يكون كلمة علم ", "يأتي بعدة حرف حلقي ", 2);
        addQuestionC21(q5);
        QuestionsC21 q6 = new QuestionsC21("كلمة فاكي B1=aki تعني :-", "قديس ", "حياة", "مدينة ", 3);
        addQuestionC21(q6);
        QuestionsC21 q7 = new QuestionsC21("كلمة محبة تعني :-", "اغابي Ajap3", "اكليسيا Ekk,l3cia", "ران Ran", 1);
        addQuestionC21(q7);
        QuestionsC21 q8 = new QuestionsC21("كلمة ملاك يعني :-  ", "جوم Gom", "انجسلوس   Ajjeloc", "ميرون mvron", 2);
        addQuestionC21(q8);
        QuestionsC21 q9 = new QuestionsC21("كلمة  Diakwn تنطق :- ", "ذون ", "ذوكون", "ذياكون ", 3);
        addQuestionC21(q9);

        QuestionsC21 q10 = new QuestionsC21("A is correctT11", "اي - اية ", "اي - ياء خفيفة ", "يوتا - ياء طويلة ", 1);
        addQuestionC21(q10);
        QuestionsC21 q11 = new QuestionsC21("حرف ^ يسمي :- ", "سيما ", "سوؤو", "غما ", 2);
        addQuestionC21(q11);
        QuestionsC21 q12 = new QuestionsC21("حرف Z يسمي ..... وينطق ..... :-", "ابسي - بس", "اكسي - كسي ", "زيتا - ز", 3);
        addQuestionC21(q12);
        QuestionsC21 q13 = new QuestionsC21("حرف ) يسمي .... وينطق ......:-", "ثيتا  - ث ت ", "اوميكرون - و", "سيما - س ", 1);
        addQuestionC21(q13);
        QuestionsC21 q14 = new QuestionsC21("كلمة سلام تعني :- ", "أوأوو Wov", "شيري   Xere", "يوت Iwt", 2);
        addQuestionC21(q14);
        QuestionsC21 q15 = new QuestionsC21("كلمة سيدتنا  تعني : -", "بافلوس Pav,loc", "ثيليل )el3l", "تين نيب Tenn3b", 3);
        addQuestionC21(q15);
        QuestionsC21 q16 = new QuestionsC21("كلمة  Pwnq إبؤنخ  تعني :-", "الحياة ", "الروح ", "المحبة ", 1);
        addQuestionC21(q16);

    }

    private void addQuestionC21(QuestionsC21 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC21, question.getQuestionC21());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C21, question.getOption1C21());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C21, question.getOption2C21());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C21, question.getOption3C21());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC21, question.getAnswerNrC21());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC21, null, cv);
    }

    public ArrayList<QuestionsC21> getAllQuestionsC21() {
        ArrayList<QuestionsC21> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC21, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC21 question = new QuestionsC21();
                question.setQuestionC21(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC21)));
                question.setOption1C21(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C21)));
                question.setOption2C21(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C21)));
                question.setOption3C21(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C21)));
                question.setAnswerNrC21(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC21)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // C22
    private void fillQuestionsTableC22() {
        QuestionsC22 q1 = new QuestionsC22("الحرف ÷I اسمة .... وينطق :- ", "يوتا -ي", "ايتا -ي", "ابسلن -ي", 1);
        addQuestionC22(q1);
        QuestionsC22 q2 = new QuestionsC22("الحرف Kاسمة ...وينطق ....:- ", "لولا - ل", "كبا - ك", "هوري - هـ", 2);
        addQuestionC22(q2);
        QuestionsC22 q3 = new QuestionsC22("الحرف L يسمي .... وينطق .....:- ", "دلتا -د", "الفا - ا ", "لولا -ل", 3);
        addQuestionC22(q3);
        QuestionsC22 q4 = new QuestionsC22("الحرف m - M  يسمي .... وينطق....:- ", "مي- م", "ني - ن", "مي -ي", 1);
        addQuestionC22(q4);
        QuestionsC22 q5 = new QuestionsC22("الحرف ني شكلة :- ", "$", "N", "m - M", 2);
        addQuestionC22(q5);
        QuestionsC22 q6 = new QuestionsC22("كلمة الشعب تعني :-", "بي نيشتي Pini12t", "يوت Iwt", "بي  لاؤس Pilaoc", 3);
        addQuestionC22(q6);
        QuestionsC22 q7 = new QuestionsC22("كلمة   بي نيشتي Pini12t تعني :-", "العظيم", "الله ", "الابدي", 1);
        addQuestionC22(q7);
        QuestionsC22 q8 = new QuestionsC22("كلمة  اسمو  'Cmov تعني  :-", "يقول ", "يسبح ", "يضرب", 2);
        addQuestionC22(q8);
        QuestionsC22 q9 = new QuestionsC22("كلمة   I3covc ايسوس  تعني :-", "الاب ", "الله ", "يسوع ", 3);
        addQuestionC22(q9);

        QuestionsC22 q10 = new QuestionsC22("كلمة Kvrie Ele3con كيريي إليسون  تعني :-", "يارب ارحم ", "ضابط الكل ", "مخلصنا الصالح ", 1);
        addQuestionC22(q10);
        QuestionsC22 q11 = new QuestionsC22("حرف &  يسمي : ", "زيتا ", "اكسي ", "سو ", 2);
        addQuestionC22(q11);
        QuestionsC22 q12 = new QuestionsC22("حرف ×O يسمي ....وينطق ....:-", "اوميجا - و", "ابسلن - و", "اوميكرون - و ", 3);
        addQuestionC22(q12);
        QuestionsC22 q13 = new QuestionsC22("كلمة الكنيسة تعني :-", "Tekkl3cia  تي إكليسيا", "Ajjeloc انجيلوس ", "Jor غار ", 1);
        addQuestionC22(q13);
        QuestionsC22 q14 = new QuestionsC22("كلمة مستحق  تعني :-", "Ajjeloc انجيلوس ", "A1987ioc اكسيوس ", "`@l3l إشليل ", 2);
        addQuestionC22(q14);
        QuestionsC22 q15 = new QuestionsC22("كلمة Niajioc ني انجيلوس تعني :-", "الشهداء ", "الملائكة ", "القديسين ", 3);
        addQuestionC22(q15);

    }

    private void addQuestionC22(QuestionsC22 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC22, question.getQuestionC22());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C22, question.getOption1C22());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C22, question.getOption2C22());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C22, question.getOption3C22());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC22, question.getAnswerNrC22());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC22, null, cv);
    }

    public ArrayList<QuestionsC22> getAllQuestionsC22() {
        ArrayList<QuestionsC22> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC22, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC22 question = new QuestionsC22();
                question.setQuestionC22(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC22)));
                question.setOption1C22(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C22)));
                question.setOption2C22(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C22)));
                question.setOption3C22(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C22)));
                question.setAnswerNrC22(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC22)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // C23
    private void fillQuestionsTableC23() {
        QuestionsC23 q1 = new QuestionsC23("حرف \"}|P يسمي .... وينطق ......", "بي - ب", "ني -ن ", "فاي - ف", 1);
        addQuestionC23(q1);
        QuestionsC23 q2 = new QuestionsC23("حرف R يسمي ....وينطق.......", "فاي -ف ", "رو - ر", "ابسي - بس", 2);
        addQuestionC23(q2);
        QuestionsC23 q3 = new QuestionsC23("حرف سيما شكلة :-", "E", "m", "C", 3);
        addQuestionC23(q3);
        QuestionsC23 q4 = new QuestionsC23("حرف فاي شكلة :-", "$", "R", "Q", 1);
        addQuestionC23(q4);
        QuestionsC23 q5 = new QuestionsC23("حرف F يسمي........ وينطق........", "فاي -ي", "في -ف  ", "ابسي -بس", 2);
        addQuestionC23(q5);
        QuestionsC23 q6 = new QuestionsC23("كلمة Pe4ran  بيف ران تعني :-", "ابنة ", "الة", "اسمة ", 3);
        addQuestionC23(q6);
        QuestionsC23 q7 = new QuestionsC23("كلمة Petra بيترا تعني :-", "صخره ", "فأس", "يد", 1);
        addQuestionC23(q7);
        QuestionsC23 q8 = new QuestionsC23("كلمة الجسد تعني :-", "بي نيشتي Pini12t", "بي  سوما  Piecwma", "بي لاؤس Pilaoc", 2);
        addQuestionC23(q8);
        QuestionsC23 q9 = new QuestionsC23("كلمة الدم تعني :-", "بي سوما Picwma", "اسمو   `Cmov", "بي اسنوف Pi11`cno4", 3);
        addQuestionC23(q9);

        QuestionsC23 q10 = new QuestionsC23("كلمة سماء تعني:-", "اتفيه", "اكليسيا", "لاؤس", 1);
        addQuestionC23(q10);
        QuestionsC23 q11 = new QuestionsC23("حرف T يسمي ..... وينطق .....:-", "تي - ت", "تاف - ت", "تاف - تي ", 2);
        addQuestionC23(q11);
        QuestionsC23 q12 = new QuestionsC23("حرف ابسلن v ينطق :-", "ي - ك - غ", "ن - ج - غ", "ي - و - غ", 3);
        addQuestionC23(q12);
        QuestionsC23 q13 = new QuestionsC23("كلمة  Twbh طوبة تعني :-", "يطلب  ", "يرتل", "يهتف", 1);
        addQuestionC23(q13);
        QuestionsC23 q14 = new QuestionsC23("كلمة ابن تعني :-", "شيري @ere", "ايوس Gioc", "يوت  Iwt", 2);
        addQuestionC23(q14);
        QuestionsC23 q15 = new QuestionsC23("حرف W اوميجا ينطق :-", "ج", "م", "و", 3);
        addQuestionC23(q15);
        QuestionsC23 q16 = new QuestionsC23("حرف X يسمي ...:-", "كي", "اكسي", "كبا", 1);
        addQuestionC23(q16);
        QuestionsC23 q17= new QuestionsC23("حرف كي X ينطق ...:-", "ف - ي - و ", "ك - ش - خ", "غ - ج - ن", 2);
        addQuestionC23(q17);
        QuestionsC23 q18 = new QuestionsC23("حرف شاي شكله :-", "m", "S", "@", 3);
        addQuestionC23(q18);


        QuestionsC23 q19 = new QuestionsC23("كلمة اشليل  `@l3l تعني :-", "يصلي ", "يسبح ", "يسجد ", 1);
        addQuestionC23(q19);
        QuestionsC23 q20= new QuestionsC23("كلمة المجد تعني :- ", "بي لاؤس Pilaoc ", "بي اوؤو Piwov", "جوم Gom", 2);
        addQuestionC23(q20);
        QuestionsC23 q21 = new QuestionsC23("كلمة المزمور تعني :-", "بافلوس  Pavloc", "تي اكليسيا Tekkl3cia", "بي بصالموس Pi Yalmoc", 3);
        addQuestionC23(q21);
        QuestionsC23 q22 = new QuestionsC23("حرف q يسمي ... وينطق ...:-", "خاي - خ", "شاي - ش", "هوري - ه ", 1);
        addQuestionC23(q22);
        QuestionsC23 q23 = new QuestionsC23("حرف جنجا شكلة :-", "L", "G", "D", 2);
        addQuestionC23(q23);
        QuestionsC23 q24 = new QuestionsC23("حرف جنجا  G ينطق :-", "ن", "أ", "ج ", 3);
        addQuestionC23(q24);
        QuestionsC23 q25 = new QuestionsC23("حرف هوري شكلة ... وينطق ....:-", "H - هـ", "q - ÷÷هـ", "L - و", 1);
        addQuestionC23(q25);
        QuestionsC23 q26 = new QuestionsC23("حرف S يسمي .... وينطق ...:-", "خاي - خ ", "تشيما - تش ", "سو - سو ", 2);
        addQuestionC23(q26);
        QuestionsC23 q27 = new QuestionsC23("حرف % يسمي .... وينطق .....:-", "تاف - ت", "تي - ت ", "تي - تي ", 3);
        addQuestionC23(q27);

        QuestionsC23 q28 = new QuestionsC23("كلمة جدة تعني :-", "بيف خلوي ,Pi481qelloi", "تاماف Tamav", "شيري @eri", 1);
        addQuestionC23(q28);
        QuestionsC23 q29 = new QuestionsC23("كلمة  H3t هيت تعني :-", "روح ", "قلب ", "عقل ", 2);
        addQuestionC23(q29);
        QuestionsC23 q30 = new QuestionsC23("كلمة  Nah5 تعني :-", "اعمال ", "قلب ", "ايمان ", 3);
        addQuestionC23(q30);

        QuestionsC23 q31 = new QuestionsC23("كلمة ربنا تعني :-", "بين تشويس  Pen soic", "ايسوس  I3covc", "يوت  Iwt", 1);
        addQuestionC23(q31);
        QuestionsC23 q32 = new QuestionsC23("كلمة العدو تعني :-", "بي نيشتي Pini35", "بي جاجي Pigagi", "بي رومي Pirwmi", 2);
        addQuestionC23(q32);

    }

    private void addQuestionC23(QuestionsC23 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC23, question.getQuestionC23());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C23, question.getOption1C23());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C23, question.getOption2C23());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C23, question.getOption3C23());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC23, question.getAnswerNrC23());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC23, null, cv);
    }

    public ArrayList<QuestionsC23> getAllQuestionsC23() {
        ArrayList<QuestionsC23> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC23, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC23 question = new QuestionsC23();
                question.setQuestionC23(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC23)));
                question.setOption1C23(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C23)));
                question.setOption2C23(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C23)));
                question.setOption3C23(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C23)));
                question.setAnswerNrC23(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC23)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
////////////////////////////////////////////////////////////////////////////////////

    //T31
    private void fillQuestionsTableT31() {
        QuestionsT31 q1 = new QuestionsT31("متي يبدأ اليوم الكنسي؟", "عند غروب الشمس ", "عند شروق الشمس ", "عند الصباح ", 1);
        addQuestionT31(q1);
        QuestionsT31 q2 = new QuestionsT31("متي تصلي رفع بخور عشية يوم الاحد ؟", "مساء السبت ", "غروب يوم السبت ", "فجر يوم الاحد ", 2);
        addQuestionT31(q2);
        QuestionsT31 q3 = new QuestionsT31("متي تصلي رفع بخور باكر؟", "مساء يوم السبت ", "صباح يوم الاحد ", "فجر يوم  الاحد ", 3);
        addQuestionT31(q3);
        QuestionsT31 q4 = new QuestionsT31("متي ينتهي اليوم الكنسي ؟", "بانتهاء القداس ", "بانتهاء العشية ", "بانتهاء التسبحة ", 1);
        addQuestionT31(q4);
        QuestionsT31 q5 = new QuestionsT31("بداية القداس الالهي  عند رفع بخور باكر ؟", "صح ", "غلط ", "....", 2);
        addQuestionT31(q5);
        QuestionsT31 q6 = new QuestionsT31("لية القداس بيبدأ من عشية اليوم اللي قبلة ؟ ليه الوقت الطويل ده كلة .؟", "حب الكنيسة في التسبحه فوضعت صلوات كثيرة ", "عادات وتقاليد تعلمناها ولا يمكننا ان نفهمها ", "لكى تعدنا الكنيسة جيدا جدا للقاء ربنا و لا نذهب للقائه فجأة و لكن نبقى ساهرين نصلى و نسبح و نجاهد و نقدم توبة", 3);
        addQuestionT31(q6);
        QuestionsT31 q7 = new QuestionsT31("علي ماذا تحتوي الاجبية ؟", "صلوات اليوم ", "الثلاث تسابيح ", "سيرة القديسين ", 1);
        addQuestionT31(q7);
        QuestionsT31 q8 = new QuestionsT31("تسبحة رفع بخور عشية ونصف الليل و باكر توجد في .........:-", "القطمارس ", "الابصلمودية ", "الخولاجي ", 2);
        addQuestionT31(q8);
        QuestionsT31 q9 = new QuestionsT31("...... هو كتاب يوجد فيه سيرة القديسين او شهيد اليوم ويقرأ بعد الابركسيس ", "الدفنار ", "الابصلمودية ", "السنكسار ", 3);
        addQuestionT31(q9);

        QuestionsT31 q10 = new QuestionsT31("ما هو الكتاب الذي يحتوي علي سيرة القديسين او شهيد اليوم ويستخدم في تسبحة نصف الليل ؟", "الدفنار ", "السنكسار ", "الابصلمودية ", 1);
        addQuestionT31(q10);
        QuestionsT31 q11 = new QuestionsT31("تبدأ صلوات القداس  .......:-", "بصلاة الشكر ", "بفتح ستر الهيكل ", "بصلوات السواعي ", 2);
        addQuestionT31(q11);
        QuestionsT31 q12 = new QuestionsT31("دوره البخور  يلف ابونا حول المذبح .... مرات ", "6", "7", "3", 3);
        addQuestionT31(q12);
        QuestionsT31 q13 = new QuestionsT31("ما هي ايام الواطس؟", "الاربعاء - الخميس - الجمعه - السبت ", "الخميس - الجمعه - السبت - الاحد ", "الجمعه - السبت - الاحد - الاثنين ", 1);
        addQuestionT31(q13);
        QuestionsT31 q14 = new QuestionsT31("ما هي ايام الادام ؟", "الاربعاء - الخميس - الجمعه - السبت ", "الاحد - الاثنين - الثلاثاء ", "الاثنين - الثلاثاء - الاربعاء ", 2);
        addQuestionT31(q14);
        QuestionsT31 q15 = new QuestionsT31("يصلي ابونا ..... اواشي في رفع بخور باكر وعشية ", "2", "3", "4", 3);
        addQuestionT31(q15);
        QuestionsT31 q16 = new QuestionsT31("في رفع بخور باكر يوم السبت ورفع بخور العشية طوال العام تصلي الكنيسة اوشية.......:-  ", "الراقدين ", "المسافرين ", "المرضي ", 1);
        addQuestionT31(q16);
        QuestionsT31 q17 = new QuestionsT31("هل يصلي ابونا ال 4 اواشي في كل رفع بخور باكر وعشية ؟", "صح ", "غلط ", ".....", 2);
        addQuestionT31(q17);
        QuestionsT31 q18 = new QuestionsT31("في باكر كل الايام ماعدا السبت يصلي اوشية ....:-", "المسافرين ", "الراقدين ", "المرضي ", 3);
        addQuestionT31(q18);

        QuestionsT31 q19 = new QuestionsT31("في كل الايام من الاسبوع نصلي اوشية ...... ماعدا يوم الاحد و ايام الاعياد", "المسافرين ", "الراقدين ", "المرضي ", 1);
        addQuestionT31(q19);
        QuestionsT31 q20 = new QuestionsT31("اوشية ....... تصلي في باكر يوم الاحد و الاعياد و كان الاباء يقدمون قرابين للكنيسة (بخور، ستور، كتب القراءة، أوانى المذبح.... الخ)", "المسافرين ", "القرابين ", "المرضي ", 2);
        addQuestionT31(q20);
        QuestionsT31 q21 = new QuestionsT31("لماذا يدور الكاهن بالشورية وسط الكنيسة ؟", "لجمع توبة الناس", "نطلب من القديسين الشفاعه لاننا نكون نصلي الذكصولوجيات ", "الاجابتين صح ", 3);
        addQuestionT31(q21);
        QuestionsT31 q22 = new QuestionsT31("اثناء دورة ابونا بالشورية وسط الكنيسة يمكن للشعب الاعتراف عن خطاياهم  سرا لان ابونا عندما يرجع الي الهيكل يقرأ حل جماعي  ؟", "صح ", "غلط ", ".....", 1);
        addQuestionT31(q22);
        QuestionsT31 q23 = new QuestionsT31("بعدما يصلي الشعب قانون الايمان يقف ابونا علي الهيكل وكون ماسكا .......", "الشورية ", "3 شمعات ", "الصليب ", 2);
        addQuestionT31(q23);
        QuestionsT31 q24 = new QuestionsT31(" اثناء لبس التونية يصلي الشماس .......", "مزمور 92 الرب ماك ولبس الجلال", "مزمور 29 اعظمك يارب لانك احتضنتني ", "الاجابتين صح ", 3);
        addQuestionT31(q24);
        QuestionsT31 q25 = new QuestionsT31("ايام الاعياد و الفطار نصلي ........ ", "صلاة الساعة الثالثة و السادسة فقط", "يصلي الثالثة و السادسة و التاسعة و الغروب و النوم", "يصلي الثالثة و السادسة و التاسعة", 1);
        addQuestionT31(q25);
        QuestionsT31 q26 = new QuestionsT31("ايام الصوم نصلي ..... ", "صلاة الساعة الثالثة و السادسة فقط", "صلاة الساعة الثالثة و السادسة و التاسعة", "صلاة الساعة الثالثة و السادسة و التاسعة و الغروب و النوم", 2);
        addQuestionT31(q26);
        QuestionsT31 q27 = new QuestionsT31("ايام الصوم الكبير وصوم يونان نصلي ", "صلاة الساعة الثالثة و السادسة فقط", "صلاة الساعة الثالثة و السادسة و التاسعة", "صلاة الساعة الثالثة و السادسة و التاسعة و الغروب و النوم", 3);
        addQuestionT31(q27);
        QuestionsT31 q28 = new QuestionsT31("يوم عيد العنصرة نصلي ..... ", "صلاة الساعة الثالثة فقط ", "صلاة الساعة الثالثة و السادسة فقط", "صلاة الساعة  الثالثة و السادسة و التاسعة", 1);
        addQuestionT31(q28);

    }

    private void addQuestionT31(QuestionsT31 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT31, question.getQuestionT31());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T31, question.getOption1T31());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T31, question.getOption2T31());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T31, question.getOption3T31());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT31, question.getAnswerNrT31());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET31, null, cv);
    }

    public ArrayList<QuestionsT31> getAllQuestionsT31() {
        ArrayList<QuestionsT31> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET31, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT31 question = new QuestionsT31();
                question.setQuestionT31(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT31)));
                question.setOption1T31(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T31)));
                question.setOption2T31(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T31)));
                question.setOption3T31(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T31)));
                question.setAnswerNrT31(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT31)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    // T32
    private void fillQuestionsTableT32() {
        QuestionsT32 q1 = new QuestionsT32("ماذا يحدث بعد صلاة السواعي  مباشرا ؟", "يغسل ابونا ايديه ", "يختار ابونا الحمل  ", "دورة البولص ", 1);
        addQuestionT32(q1);
        QuestionsT32 q2 = new QuestionsT32("عند اختيارالحمل يقف شماس ......... ابونا حاملا قارورة الاباركة ", "يسار ", "يمين ", "امام ", 2);
        addQuestionT32(q2);
        QuestionsT32 q3 = new QuestionsT32("عند اختيارالحمل يقف شماس ......... ابونا حاملا قارورة  الماء ", "امام ", "يمين ", "يسار ", 3);
        addQuestionT32(q3);
        QuestionsT32 q4 = new QuestionsT32("في تقدمة الحمل عدد القربان يجب ان يكون  ......", "عدد فردي ", "عدد زوجي ", "عدد اولي ", 1);
        addQuestionT32(q4);
        QuestionsT32 q5 = new QuestionsT32("يوجد صليب كبير في القربانة يسمي ........و يشير الي المسيح نفسة ", "ذيسبوتيكون", "اسباديكون", "الاجابتين صح ", 3);
        addQuestionT32(q5);
        QuestionsT32 q7 = new QuestionsT32("يوجد 12 صليب صغير في القربانه اشارة الي ......:-", "ال 12 تلميذ ", "اسرار الكنيسة ", "الرسل جميعهم ", 1);
        addQuestionT32(q7);
        QuestionsT32 q8 = new QuestionsT32("يوجد 5 ثقوب في القربانة اشارة الي .....", "اسرار الكنيسة ", "جراحات المسيح ", "التلاميذ ", 2);
        addQuestionT32(q8);
        QuestionsT32 q9 = new QuestionsT32("في تقدمة الحمل يختار ابونا ...... ", "افضل اقربانة فقط ", "افضل قربانة  وافضل اباركة ", "افضل قربانة وافضل اباركة وافضل ماء ", 3);
        addQuestionT32(q9);

        QuestionsT32 q10 = new QuestionsT32("بعدما يضع  ابونا الاباركة في الكاس يملا....... القارورة بالماء ويصبة في الكاس . ", "ثلث ", "ربع ", "نص ", 1);
        addQuestionT32(q10);
        QuestionsT32 q11 = new QuestionsT32("بعد اخيار الحمل  يمسح ابونا  القربانة بالماء ويلفها في لفافة ويضع الصليب وهو ليس  مائل؟", "صح ", "غلط ", "......", 2);
        addQuestionT32(q11);
        QuestionsT32 q12 = new QuestionsT32("بعد صلاة الشكر يغطي المذبح بغطاء ابيض كبير اسمة .......", "مستير ", "اسباديكون", "الابروسفارين ", 3);
        addQuestionT32(q12);
        QuestionsT32 q13 = new QuestionsT32("يوضع فوق الابروسفارين لفافة مثلثة اشارة ل.......", "للختم الذي كان علي قبر المسيح ", "القيامة الثانية ", "قيامة المسيح ", 1);
        addQuestionT32(q13);
        QuestionsT32 q14 = new QuestionsT32("عشان الشماس يقدر يلبس التونيه لازم يكون موجود قبل تحليل الخدام مش لازم يحضر من اول القداس ؟", "صح ", "غلط ", ".....", 2);
        addQuestionT32(q14);
        QuestionsT32 q15 = new QuestionsT32("في دورة البولس يقف ابونا ماسكا الشورية ويقف الشماس امامة ماسكا ....", "الصليب فقط", "البشارة فقط ", "الصليب والبشارة ", 3);
        addQuestionT32(q15);
        QuestionsT32 q16 = new QuestionsT32("يقوم ابونا بدورة بخور   .......:- ", "البولس و الابركسيس ", "السنكسار و الابركسيس ", "الكاثوليكون و الابركسيس ", 1);
        addQuestionT32(q16);
        QuestionsT32 q17 = new QuestionsT32("طول ما ابونا ماسك الشورية الشمامسة يقولون الحان ل.......:-", "للملائكة ", "للعذراء مريم ", "لشهيد اليوم ", 2);
        addQuestionT32(q17);
        QuestionsT32 q18 = new QuestionsT32("بعد الانجيل نصلي 3 اواشي هما ......:-", "المرضي و المسافرين  و السلام ", "السلام و الاجتماعات و المسافرين ", "السلام  و البابا  و الاجتماعات ", 3);
        addQuestionT32(q18);

        QuestionsT32 q19 = new QuestionsT32(" في صلاة الصلح يعلن ابونا الصلح الذي تم بين السماء و الارض و الحب و السلام الذي اصبح بعد تجسد السيد المسيح؟؟", "صح", "غلط", ".....", 1);
        addQuestionT32(q19);
        QuestionsT32 q20 = new QuestionsT32("في نهاية صلاة الصلح يمسك الشماس الصليب أمام الكاهن و ابونا يرفع اللفافة المثلثة علامة على........", "الافتخار بالصليب  ", "العداوة اللى كانت بين السماء و الأرض و هدمت بالصليب", "انتظار المجيئ الثاني ", 2);
        addQuestionT32(q20);



        // نفص واحد من عدد الاسأله عشان شيلت رقم 6
    }

    private void addQuestionT32(QuestionsT32 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT32, question.getQuestionT32());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T32, question.getOption1T32());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T32, question.getOption2T32());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T32, question.getOption3T32());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT32, question.getAnswerNrT32());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET32, null, cv);
    }

    public ArrayList<QuestionsT32> getAllQuestionsT32() {
        ArrayList<QuestionsT32> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET32, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT32 question = new QuestionsT32();
                question.setQuestionT32(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT32)));
                question.setOption1T32(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T32)));
                question.setOption2T32(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T32)));
                question.setOption3T32(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T32)));
                question.setAnswerNrT32(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT32)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    // T33
    private void fillQuestionsTableT33() {
        QuestionsT33 q1 = new QuestionsT33("تبدأ صلاة الأنافورة من", "ابونا يقول الرب مع جميعكم", "تقديم الحمل", "صلاة الصلح", 1);
        addQuestionT33(q1);
        QuestionsT33 q2 = new QuestionsT33("في مرد الشماس اللي بيقول فية \"امين امين امين اؤمن ...\"(الاعتراف الصغير)بيطلب من الشعب الصلاة من اجل", "نصلي من اجل التناول باستحقاق", "الذين طلبوا منا اننا نصلي لهم", "الاثنين معا", 3);
        addQuestionT33(q2);
        QuestionsT33 q3 = new QuestionsT33("لقمة البركة اللي بيوزعها ابونا هى", "الحمل", "قربان عادى", "باقي القربان اللي كان في طبق الحمل", 3);
        addQuestionT33(q3);
        QuestionsT33 q4 = new QuestionsT33("عندما يقول الكاهن \"ارفعوا قلوبكم\" يقوم برشم", "الشمامسة خدام المذبح", "ذاته", "الشعب", 1);
        addQuestionT33(q4);
        QuestionsT33 q5 = new QuestionsT33("يرشم الكاهن ذاته عندما يقول", "الرب مع جميعكم", "فلنشكر الرب", "مع روحك ايضا", 2);
        addQuestionT33(q5);
        QuestionsT33 q6 = new QuestionsT33("يمسك الشمامسة الشموع فى الهيكل عموما عندما يقوم الكاهن", "بمسك الشورية", "بمسك درج البخور", "بمسك الاسرار المقدسة", 3);
        addQuestionT33(q6);
        QuestionsT33 q7 = new QuestionsT33("عندما يقول الكاهن \"لان كل مرة تأكلون من هذا الخبز و تشربون من هذه الكأس\" يشير بيديه الى", "الجسد و الدم", "المذبح", "الصليب", 1);
        addQuestionT33(q7);
        QuestionsT33 q8 = new QuestionsT33("اول اوشية بعد صلوات التقديس هى اوشية", "الرحمة", "السلامة", "القسوس", 2);
        addQuestionT33(q8);
        QuestionsT33 q9 = new QuestionsT33("نذكر فى القداس الالهى .... و ذلك للصلاة من أجلهم و شركة مع السمائببن", "كل الراقدين على ايمان المسيح فقط", "القديسين الذين حافظوا على الإيمان والبطاركة الذين رقدوا فقط", "كل ما سبق", 3);
        addQuestionT33(q9);
        QuestionsT33 q10 = new QuestionsT33("قبل صلاة القسمة نصلى قطعة تسمى", "مقدمة القسمة", "التحليل", "الاعتراف", 1);
        addQuestionT33(q10);

        QuestionsT33 q11 = new QuestionsT33("تسمى صلاة القسمة بهذا الاسم لانه فيها", "يقسم الكاهن الجسد المقدس بدخل الصينية", "يقسم الكاهن الجسد المقدس على الشمامسة", "يقسم الكاهن الجسد المقدس على لشعب" ,1);
        addQuestionT33(q11);
        QuestionsT33 q12 = new QuestionsT33("الاعتراف هو عبارة عن", "مجرد تحليل يقوله الكاهن سرا فى نهاية القداس", "قانون ايمان ثانى بحياة المسيح و ان هذا هو الجسد و الدم الحقيقيين لنستحق ان نتناول منه"         , "تقديس للجسد و الدم المقدسين", 2);
        addQuestionT33(q12);
        QuestionsT33 q13 = new QuestionsT33("يصلى لحن المزمور ... فى التوزيع دائما", "149", "151", "150", 3);
        addQuestionT33(q13);



    }

    private void addQuestionT33(QuestionsT33 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONT33, question.getQuestionT33());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1T33, question.getOption1T33());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2T33, question.getOption2T33());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3T33, question.getOption3T33());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRT33, question.getAnswerNrT33());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMET33, null, cv);
    }

    public ArrayList<QuestionsT33> getAllQuestionsT33() {
        ArrayList<QuestionsT33> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMET33, null);

        if (c.moveToFirst()) {
            do {
                QuestionsT33 question = new QuestionsT33();
                question.setQuestionT33(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONT33)));
                question.setOption1T33(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1T33)));
                question.setOption2T33(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2T33)));
                question.setOption3T33(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3T33)));
                question.setAnswerNrT33(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRT33)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    //C31
    private void fillQuestionsTableC31() {
        QuestionsC31 q1 = new QuestionsC31("حرف X ينطق : - ", "ك-ش-خ", "و-ف-ي", "غ-خ-ك", 1);
        addQuestionC31(q1);
        QuestionsC31 q2 = new QuestionsC31("حرف X ينطق ش اذا جاء :- ", "بعدة حرف متحرك ", "بعدة حرف متحرك للكسر ", "قبلة حرف حلقي", 2);
        addQuestionC31(q2);
        QuestionsC31 q3 = new QuestionsC31("كلمة صلاة  تعني  :- ", "E90ov=ab ", "Iwt", "Evx3 ", 3);
        addQuestionC31(q3);
        QuestionsC31 q4 = new QuestionsC31("كلمة  Xrictoc  تعني :- ", "مسيح", "يسوع", "الله ", 1);
        addQuestionC31(q4);
        QuestionsC31 q5 = new QuestionsC31("كلمة Xrwm تعني :- ", "حياة ", "نار", "اب ", 2);
        addQuestionC31(q5);
        QuestionsC31 q6 = new QuestionsC31("حرف B ينطق ف اذا جاء :- ", "قبلة حرف متحرك ", "بعدة A-)", "بعده حرف متحرك ", 3);
        addQuestionC31(q6);
        QuestionsC31 q7 = new QuestionsC31("كلمة Twbh  تعني :- ", "اطلبوا ", "ضل ", "اسجدوا ", 1);
        addQuestionC31(q7);
        QuestionsC31 q8 = new QuestionsC31("كلمة Niben تعني:- ", "شئ", "كل", "بعد", 2);
        addQuestionC31(q8);
        QuestionsC31 q9 = new QuestionsC31("حرف v ينطق :- ", "ك-ش-خ", "غ-خ-و", "ف-و-ي", 3);
        addQuestionC31(q9);
        QuestionsC31 q10 = new QuestionsC31("كلمة ام تعني :- ", "Mav", " Eva", "Kvrie", 1);
        addQuestionC31(q10);
        QuestionsC31 q11 = new QuestionsC31("ما نطق ev  :-", "أف", "إف ", "اوو ", 2);
        addQuestionC31(q11);
        QuestionsC31 q12 = new QuestionsC31("ما نطق Ov  :-", "أف", "إف ", "اوو ", 3);
        addQuestionC31(q12);
        QuestionsC31 q13 = new QuestionsC31(" كلمة رب تعني  :-  ", "Kvrie", "Tovbo", "Eva", 1);
        addQuestionC31(q13);
        QuestionsC31 q14 = new QuestionsC31("حرف % ينطق :-  ", "ت", "تي ", "ي", 2);
        addQuestionC31(q14);
        QuestionsC31 q15 = new QuestionsC31("حرف J ينطق :-  ", "ك-ش-خ", "ج-ن-ش", "ج-ن-غ", 3);
        addQuestionC31(q15);
        QuestionsC31 q16 = new QuestionsC31("ينطق J  ج اذا جاء:- ", "بعده حرف متحرك للكسر ", "جاء بعده K ", "فيما عدا ذلك ", 1);
        addQuestionC31(q16);
        QuestionsC31 q17 = new QuestionsC31("كلمة الكرسي  تعني :- ", "ajioc", "Pitotc", "Panta", 2);
        addQuestionC31(q17);
        QuestionsC31 q18 = new QuestionsC31("كلمة pantokratwr  تعني :-   ", "والدة الاله ", "صانع السلام ", "ضابط الكل ", 3);
        addQuestionC31(q18);
        QuestionsC31 q19 = new QuestionsC31("كلمة 5srompi  تعني :-  ", "الحمامة  ", "الحسنة", "الليلويا ", 1);
        addQuestionC31(q19);
        QuestionsC31 q20 = new QuestionsC31("كلمة ajioc تعني :-  ", "ملاك ", "قدوس ", "امين ", 2);
        addQuestionC31(q20);
        QuestionsC31 q21 = new QuestionsC31("كلمة ملاك  تعني :-", "ajioc", "joljo0a", "ajjeloc", 3);
        addQuestionC31(q21);
        QuestionsC31 q22 = new QuestionsC31("كلمة انجيل تعني :-   ", "Evajjelion ", "c0erter ", "ajjeloc ", 1);
        addQuestionC31(q22);
        QuestionsC31 q23 = new QuestionsC31("حرف ) ينطق :- ", "ث-ي", "ث-ت", "ث-ن", 2);
        addQuestionC31(q23);
        QuestionsC31 q24 = new QuestionsC31("حرف  ) ينطق ت اذا جاء :-  ", "بعدة حرف متحرك ", "قبلك  @ - C ", "بعدة @ - C", 3);
        addQuestionC31(q24);
        QuestionsC31 q25 = new QuestionsC31("كلمة قفوا تعني :-  ", "Cta03te ", "klinate ", "procxwmen ", 1);
        addQuestionC31(q25);
        QuestionsC31 q26 = new QuestionsC31("حرف L ينطق :-  ", "و", "ل", "ي", 2);
        addQuestionC31(q26);
        QuestionsC31 q27 = new QuestionsC31("حرف Rينطق :- ", "و", "ل", "ر", 3);
        addQuestionC31(q27);
        QuestionsC31 q28 = new QuestionsC31("كلمة procxwmen تعني  :-  ", "ننصت  ", "احنوا ", "صلوا ", 1);
        addQuestionC31(q28);



    }

    private void addQuestionC31(QuestionsC31 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC31, question.getQuestionC31());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C31, question.getOption1C31());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C31, question.getOption2C31());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C31, question.getOption3C31());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC31, question.getAnswerNrC31());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC31, null, cv);
    }

    public ArrayList<QuestionsC31> getAllQuestionsC31() {
        ArrayList<QuestionsC31> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC31, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC31 question = new QuestionsC31();
                question.setQuestionC31(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC31)));
                question.setOption1C31(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C31)));
                question.setOption2C31(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C31)));
                question.setOption3C31(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C31)));
                question.setAnswerNrC31(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC31)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // C32
    private void fillQuestionsTableC32() {
        QuestionsC32 q1 = new QuestionsC32("حرف I ينطق :- ", "ي", "ا", "و", 1);
        addQuestionC32(q1);
        QuestionsC32 q2 = new QuestionsC32("حرف Wينطق :- ", "ا", "و", "ي", 2);
        addQuestionC32(q2);
        QuestionsC32 q3 = new QuestionsC32("حرف P ينطق :-    ", "ف", "تي", "ب", 3);
        addQuestionC32(q3);
        QuestionsC32 q4 = new QuestionsC32("كلمة مقدسة  تعني :- ", "Ajion", "Timiwn", "Pat3r", 1);
        addQuestionC32(q4);
        QuestionsC32 q5 = new QuestionsC32("كلمة Timiwn تعني :- ", "مقدسة ", "كريمة ", "روحانية ", 2);
        addQuestionC32(q5);
        QuestionsC32 q6 = new QuestionsC32("كلمة Pat3r تعني :- ", "ام ", "ابن ", "اب", 3);
        addQuestionC32(q6);
        QuestionsC32 q7 = new QuestionsC32("كلمة vioc تعني :- ", "ابن ", "ابنة ", "اخ ", 1);
        addQuestionC32(q7);
        QuestionsC32 q8 = new QuestionsC32("كلمة الروح القدس تعني :- ", "nilaoc", "pnevma ajion ", "Timiwn ", 2);
        addQuestionC32(q8);
        QuestionsC32 q9 = new QuestionsC32("كلمة الشعوب تعني :- ", "pnevma ajion ", "Timiwn ", "nilaoc", 3);
        addQuestionC32(q9);
        QuestionsC32 q10 = new QuestionsC32("حرف C ينطق :-", "س", "ن", "م", 1);
        addQuestionC32(q10);
        QuestionsC32 q11 = new QuestionsC32("حرف N ينطق :-", "س", "ن", "م", 2);
        addQuestionC32(q11);
        QuestionsC32 q12 = new QuestionsC32("حرف M ينطق :- ", "س", "ن", "م", 3);
        addQuestionC32(q12);
        QuestionsC32 q13 = new QuestionsC32("كلمة الشركة  تعني :-  ", "5koinwnia", "Kvrie `ele`3con", "p23ri", 1);
        addQuestionC32(q13);
        QuestionsC32 q14 = new QuestionsC32("كلمة mvct3rion تعني :-  ", "الشركة ", "الاسرار ", "مقدسة ", 2);
        addQuestionC32(q14);
        QuestionsC32 q15 = new QuestionsC32("كلمة e0ovab تعني :- ", "الشركة ", "الاسرار ", "مقدسة ", 3);
        addQuestionC32(q15);

    }

    private void addQuestionC32(QuestionsC32 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC32, question.getQuestionC32());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C32, question.getOption1C32());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C32, question.getOption2C32());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C32, question.getOption3C32());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC32, question.getAnswerNrC32());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC32, null, cv);
    }

    public ArrayList<QuestionsC32> getAllQuestionsC32() {
        ArrayList<QuestionsC32> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC32, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC32 question = new QuestionsC32();
                question.setQuestionC32(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC32)));
                question.setOption1C32(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C32)));
                question.setOption2C32(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C32)));
                question.setOption3C32(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C32)));
                question.setAnswerNrC32(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC32)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    // C33
    private void fillQuestionsTableC33() {
        QuestionsC33 q1 = new QuestionsC33("حرف @ ينطق :-", "ش", "ك", "بس", 1);
        addQuestionC33(q1);
        QuestionsC33 q2 = new QuestionsC33("حرف Kينطق :- ", "ش", "ك", "بس", 2);
        addQuestionC33(q2);
        QuestionsC33 q3 = new QuestionsC33("حرف Yينطق :- ", "تس", "س", "بس", 3);
        addQuestionC33(q3);
        QuestionsC33 q4 = new QuestionsC33("كلمة  الجالسون  تعني :- ", "ka03meni", "bleyate", "ovho5", 1);
        addQuestionC33(q4);
        QuestionsC33 q5 = new QuestionsC33("كلمة  انظروا  تعني :- ", "ka03meni", "bleyate", "ovho5", 2);
        addQuestionC33(q5);
        QuestionsC33 q6 = new QuestionsC33("كلمة  خوف تعني :- ", "ka03meni", "bleyate", "ovho5", 3);
        addQuestionC33(q6);
        QuestionsC33 q7 = new QuestionsC33("حرف & ينطق :- ", "كس", "بس", "تش ", 1);
        addQuestionC33(q7);
        QuestionsC33 q8 = new QuestionsC33("حرف J ينطق :- ", "ش-س-م", "غ-ن-ج", "ج-س-غ", 2);
        addQuestionC33(q8);
        QuestionsC33 q9 = new QuestionsC33("حرف D ينطق :- ", "كس", "ر-ز", "د-ذ", 3);
        addQuestionC33(q9);
        QuestionsC33 q10 = new QuestionsC33("كلمة or0odo7oc تعني :- ", "ارثوذكسية ", "العظمي ", "بطريرك ", 1);
        addQuestionC33(q10);
        QuestionsC33 q11 = new QuestionsC33("كلمة mejal3c تعني :- ", "ارثوذكسية ", "العظمي ", "بطريرك ", 2);
        addQuestionC33(q11);
        QuestionsC33 q12 = new QuestionsC33("كلمة diakwn تعني :- ", "ارثوذكسية ", "العظمي", "خادم ", 3);
        addQuestionC33(q12);
        QuestionsC33 q13 = new QuestionsC33("حرف F ينطق :- ", "ف", "تش ", "بس ", 1);
        addQuestionC33(q13);
        QuestionsC33 q14 = new QuestionsC33("حرف $ ينطق :- ", "في", "ف", "س", 2);
        addQuestionC33(q14);
        QuestionsC33 q15 = new QuestionsC33("حرف S ينطق :- ", "ف", "بس", "تش", 3);
        addQuestionC33(q15);
        QuestionsC33 q16 = new QuestionsC33("كلمة niiarwov تعني :- ", "الانهار ", "الزروع ", "العشب ", 1);
        addQuestionC33(q16);
        QuestionsC33 q17 = new QuestionsC33("كلمة povno4 تعني :- ", "الحزن ", "الفرح ", "الانهار ", 2);
        addQuestionC33(q17);
        QuestionsC33 q18 = new QuestionsC33("كلمة nicim تعني :- ", "الانهار ", "الزروع ", "العشب ", 3);
        addQuestionC33(q18);
        QuestionsC33 q19 = new QuestionsC33("كلمة rompi تعني :- ", "سنة ", "شهر ", "يوم ", 1);
        addQuestionC33(q19);
        QuestionsC33 q20 = new QuestionsC33("كلمة ovni25 تعني :- ", "قوي ", "عظيم ", "جبار ", 2);
        addQuestionC33(q20);
        QuestionsC33 q21 = new QuestionsC33("كلمة xrictianoc تعني :- ", "المصريين ", "اليهود", "المسيحيين ", 3);
        addQuestionC33(q21);
        QuestionsC33 q22 = new QuestionsC33("حرف G ينطق :- ", "ج", "ش", "س", 1);
        addQuestionC33(q22);
        QuestionsC33 q23 = new QuestionsC33("كلمة رتلوا  تعني :- ", "yalate", "all3lovia", "yvx3 ", 1);
        addQuestionC33(q23);
        QuestionsC33 q24 = new QuestionsC33("كلمة هللولله  تعني :- ", "yalate", "all3lovia", "yvx3", 2);
        addQuestionC33(q24);
        QuestionsC33 q25 = new QuestionsC33("كلمة نفوس تعني :- ", "yalate", "all3lovia", "yvx3", 3);
        addQuestionC33(q25);

    }

    private void addQuestionC33(QuestionsC33 question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizContact.QuestionsTable.COLUMN_QUESTIONC33, question.getQuestionC33());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION1C33, question.getOption1C33());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION2C33, question.getOption2C33());
        cv.put( QuizContact.QuestionsTable.COLUMN_OPTION3C33, question.getOption3C33());
        cv.put( QuizContact.QuestionsTable.COLUMN_ANSWER_NRC33, question.getAnswerNrC33());
        db.insert( QuizContact.QuestionsTable.TABLE_NAMEC33, null, cv);
    }

    public ArrayList<QuestionsC33> getAllQuestionsC33() {
        ArrayList<QuestionsC33> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContact.QuestionsTable.TABLE_NAMEC33, null);

        if (c.moveToFirst()) {
            do {
                QuestionsC33 question = new QuestionsC33();
                question.setQuestionC33(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_QUESTIONC33)));
                question.setOption1C33(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION1C33)));
                question.setOption2C33(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION2C33)));
                question.setOption3C33(c.getString(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_OPTION3C33)));
                question.setAnswerNrC33(c.getInt(c.getColumnIndex(QuizContact.QuestionsTable.COLUMN_ANSWER_NRC33)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

}


