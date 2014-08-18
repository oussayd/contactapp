
function addContact() {
       $('#contactDialog').dialog("option", "title", 'Add Contact');
       $('#contactDialog').dialog('open');
}

function editContact(id) {

       $.get("get/" + id, function(result) {
              $("#contactDialog").html(result);
              $('#contactDialog').dialog("option", "title", 'Edit Contact');
              $("#contactDialog").dialog('open');

              initializeDatePicker();
       });
}

function initializeDatePicker() {
       $(".datepicker").datepicker({
              dateFormat : "yy-mm-dd",
              changeMonth : true,
              changeYear : true,
              showButtonPanel : true
       });
}

function resetDialog(form) {

       form.find("input").val("");
}

$(document).ready(function() {

       $('#contactDialog').dialog({

              autoOpen : false,
              position : 'center',
              modal : true,
              resizable : false,
              width : 440,
              buttons : {
                     "Save" : function() {
                           $('#contactForm').submit();
                     },
                     "Cancel" : function() {
                           $(this).dialog('close');
                     }
              },
              close : function() {

                     resetDialog($('#contactForm'));
                     $(this).dialog('close');
              }
       });

       initializeDatePicker();
});