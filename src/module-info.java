/**
 * 
 */
/**
 * 
 */
module cs_3443_a5 {
  requires javafx.fxml;
  requires javafx.controls;
  
  exports application;
  opens application.controller to javafx.fxml;
}