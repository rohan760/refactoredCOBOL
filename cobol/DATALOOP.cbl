      ******************************************************************
      * Created: Thu, 1 Feb 2024 11:33:47 GMT
      * Generated by: IBM watsonx Code Assistant for Z Refactoring
      * Assistant
      * Workbook name: DATALOOP
      * Workbook id: c59ce0ae-3d8e-44dd-a429-e848d9d33a90
      * Project: $clientCOBOL_1ce104c7-f63b-4229-94cb-b55e4ef9f488
      ******************************************************************

       IDENTIFICATION DIVISION.
       PROGRAM-ID. DATALOOP.

       ENVIRONMENT DIVISION.
       INPUT-OUTPUT SECTION.
       FILE-CONTROL.
      ******************************************************************
           SELECT INFILE ASSIGN TO TLOG.
      ******************************************************************
           SELECT OUTFILE ASSIGN TO RPTFILE.
      ******************************************************************

       DATA DIVISION.
       FILE SECTION.
      ******************************************************************
       FD INFILE
           RECORDING MODE F.

       COPY TLOG.
      ******************************************************************
      * PATH : .../Cobol Include/TLOG.cpy
      * THE FOLLOWING VARIABLES ARE USED FROM THE COPYBOOK :
      *01  HRD-TEST-TRACKING-RECORD.
      *    05  TEST-RECORD-ID               PIC 9(6).
      *    05  TEST-CATEGORY                PIC X(28).
      *    05  TEST-GROUP                   PIC X(28).
      *    05  TEST-AUTHOR                  PIC X(28).
      *    05  TEST-EMAIL                   PIC X(28).
      *    05  TEST-DATE.
      *        10  TEST-YEAR                PIC 9(4).
      *        10  TEST-MONTH               PIC 9(2).
      *        10  TEST-DAY                 PIC 9(2).
      *    05  TEST-SUBJECT                 PIC X(66).
      *    05  TEST-NOTES.
      *        10  TEST-NOTE-1              PIC X(77).
      *        10  TEST-NOTE-2              PIC X(77).
      *        10  TEST-NOTE-3              PIC X(77).
      *        10  TEST-NOTE-4              PIC X(77).
      *        10  TEST-NOTE-5              PIC X(77).
      *        10  TEST-NOTE-6              PIC X(77).
      *        10  TEST-NOTE-7              PIC X(77).
      *        10  TEST-NOTE-8              PIC X(77).
      *        10  TEST-NOTE-9              PIC X(77).
      *        10  TEST-NOTE-10             PIC X(77).
      *        10  TEST-NOTE-11             PIC X(77).
      *        10  TEST-NOTE-12             PIC X(77).
      *        10  TEST-NOTE-13             PIC X(77).
      *        10  TEST-NOTE-14             PIC X(77).
      ******************************************************************
       FD OUTFILE
           RECORDING MODE V.

      ******************************************************************
      * PATH : .../zOS Cobol/TLOGRPT.cbl
       01  OUTFILE-RECORD              PIC X(200).
      ******************************************************************

       WORKING-STORAGE SECTION.
      ******************************************************************
      * PATH : .../zOS Cobol/TLOGRPT.cbl
       01  SWITCHES.
           05  TLOG-EOF-SWITCH         PIC X(1) VALUE 'N'.
       01  OUT-RECORD.
           05  FILLER                  PIC X(2)
               VALUE  SPACES.
           05  CATEGORY-OUT            PIC X(28).
           05  FILLER                  PIC X(2)
               VALUE  SPACES.
           05  GROUP-OUT               PIC X(28).
           05  FILLER                  PIC X(2)
               VALUE SPACES.
           05  AUTHOR-OUT              PIC X(28).
           05  FILLER                  PIC X(2)
               VALUE SPACES.
           05  SUBJECT-OUT             PIC X(66).
           05  ID-OUT                  PIC X(6).
           05  FILLER                  PIC X(2)
               VALUE  SPACES.
           05  DATE-OUT.
               10  FILLER              PIC X
                   VALUE '-'.
               10  DAY-OUT             PIC X(2).
               10  YEAR-OUT            PIC X(4).
               10  FILLER              PIC X
                   VALUE '-'.
               10  MONTH-OUT           PIC X(2).
      ******************************************************************

       LINKAGE SECTION.

       PROCEDURE DIVISION.
      ******************************************************************
      * PROGRAM NAME : Program:COBOL:TLOGRPT
      * PROGRAM PATH : .../zOS Cobol/TLOGRPT.cbl
      * STMT START LINE NUMBER : 184
      * STMT END LINE NUMBER : 198
       DATA-LOOP.
           MOVE TEST-RECORD-ID TO ID-OUT.
           MOVE TEST-YEAR TO YEAR-OUT.
           MOVE TEST-MONTH TO MONTH-OUT.
           MOVE TEST-DAY TO DAY-OUT.
           MOVE TEST-CATEGORY TO CATEGORY-OUT.
           MOVE TEST-GROUP TO GROUP-OUT.
           MOVE TEST-AUTHOR TO AUTHOR-OUT.
           MOVE TEST-SUBJECT TO SUBJECT-OUT.
           MOVE OUT-RECORD TO OUTFILE-RECORD.
           WRITE OUTFILE-RECORD.
           READ INFILE
               AT END
                   MOVE 'Y' TO TLOG-EOF-SWITCH
           END-READ.
      ******************************************************************
           EXIT PROGRAM.