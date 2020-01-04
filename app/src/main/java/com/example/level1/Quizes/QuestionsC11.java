package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC11 implements Parcelable{

    private String questionC11;
    private String option1C11;
    private String option2C11;
    private String option3C11;
    private int answerNrC11;


    public QuestionsC11() {
    }

    public QuestionsC11(String questionC11, String option1C11, String option2C11, String option3C11, int answerNrC11) {
        this.questionC11 = questionC11;
        this.option1C11 = option1C11;
        this.option2C11 = option2C11;
        this.option3C11 = option3C11;
        this.answerNrC11 = answerNrC11;
    }

    protected QuestionsC11(Parcel in) {
        questionC11 = in.readString();
        option1C11 = in.readString();
        option2C11 = in.readString();
        option3C11= in.readString();
        answerNrC11 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC11);
        dest.writeString(option1C11);
        dest.writeString(option2C11);
        dest.writeString(option3C11);
        dest.writeInt(answerNrC11);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC11> CREATOR = new Parcelable.Creator<QuestionsC11>() {
        @Override
        public QuestionsC11 createFromParcel(Parcel in) {
            return new QuestionsC11(in);
        }

        @Override
        public QuestionsC11[] newArray(int size) {
            return new QuestionsC11[size];
        }
    };


    public String getQuestionC11() {
        return questionC11;
    }

    public void setQuestionC11(String questionC11) {
        this.questionC11 = questionC11;
    }

    public String getOption1C11() {
        return option1C11;
    }

    public void setOption1C11(String option1C11) {
        this.option1C11 = option1C11;
    }

    public String getOption2C11() {
        return option2C11;
    }

    public void setOption2C11(String option2C11) {
        this.option2C11 = option2C11;
    }

    public String getOption3C11() {
        return option3C11;
    }

    public void setOption3C11(String option3C11) {
        this.option3C11 = option3C11;
    }

    public int getAnswerNrC11() {
        return answerNrC11;
    }

    public void setAnswerNrC11(int answerNrC11) {
        this.answerNrC11 = answerNrC11;
    }
}
