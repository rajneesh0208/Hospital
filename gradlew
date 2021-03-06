<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:id="@+id/rel_search"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:orientation="horizontal"
        android:gravity="center"
        android:layout_marginBottom="10dp"
        android:background="@drawable/search_bg"
        android:paddingEnd="8dp"
        android:paddingStart="8dp">

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center">

            <ImageView
                android:id="@+id/img_search"
                android:layout_width="20dp"
                android:layout_height="20dp"
                android:layout_marginStart="10dp"
                android:layout_centerVertical="true"
                android:layout_marginEnd="8dp"
                android:background="@drawable/search"
                android:layout_marginRight="8dp"
                />

            <EditText
                android:id="@+id/edit_search"
                android:layout_width="280dp"
                android:layout_height="45dp"
                android:layout_centerVertical="true"
                android:layout_toEndOf="@+id/img_search"
                android:fontFamily="@font/quicksand_semibold"
                android:background="@android:color/transparent"
                android:focusable="true"
                android:hint="725 5th Ave, New York, NY"
                android:imeOptions="actionSearch"
                android:inputType="text"
                android:lines="1"
                android:singleLine="true"
                android:textColor="#000000"
                android:textColorHighlight="#FFFFFF"
                android:textColorHint="#000000"
                android:textSize="16dp"
                android:layout_toRightOf="@+id/img_search" />

            <ImageView
                android:layout_width="15dp"
                android:layout_height="15dp"
                android:background="@drawable/close"
                android:foregroundGravity="center_horizontal"
                android:layout_marginEnd="30dp"
                android:layout_marginTop="16dp"
                android:layout_marginStart="340dp"/>

        </RelativeLayout>

    </Lin                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    