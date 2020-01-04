package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT33 implements Parcelable {

    private String questionT33;
    private String option1T33;
    private String option2T33;
    private String option3T33;
    private int answerNrT33;


    public QuestionsT33() {
    }


    public QuestionsT33(String questionT33, String option1T33, String option2T33, String option3T33, int answerNrT33) {
        this.questionT33 = questionT33;
        this.option1T33 = option1T33;
        this.option2T33 = option2T33;
        this.option3T33 = option3T33;
        this.answerNrT33 = answerNrT33;
    }

    protected QuestionsT33(Parcel in) {
        questionT33 = in.readString();
        option1T33 = in.readString();
        option2T33 = in.readString();
        option3T33= in.readString();
        answerNrT33 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT33);
        dest.writeString(option1T33);
        dest.writeString(option2T33);
        dest.writeString(option3T33);
        dest.writeInt(answerNrT33);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT33> CREATOR = new Creator<QuestionsT33>() {
        @Override
        public QuestionsT33 createFromParcel(Parcel in) {
            return new QuestionsT33(in);
        }

        @Override
        public QuestionsT33[] newArray(int size) {
            return new QuestionsT33[size];
        }
    };


    public String getQuestionT33() {
        return questionT33;
    }

    public void setQuestionT33(String questionT33) {
        this.questionT33 = questionT33;
    }

    public String getOption1T33() {
        return option1T33;
    }

    public void setOption1T33(String option1T33) {
        this.option1T33 = option1T33;
    }

    public String getOption2T33() {
        return option2T33;
    }

    public void setOption2T33(String option2T33) {
        this.option2T33 = option2T33;
    }

    public String getOption3T33() {
        return option3T33;
    }

    public void setOption3T33(String option3T33) {
        this.option3T33 = option3T33;
    }

    public int getAnswerNrT33() {
        return answerNrT33;
    }

    public void setAnswerNrT33(int answerNrT33) {
        this.answerNrT33 = answerNrT33;
    }
}
