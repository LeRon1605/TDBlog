function Validator(options) {
  var selectorRules = {};

  function getParentElement(element, selector) {
    while (element.parentElement) {
      if (element.parentElement.matches(selector)) {
        return element.parentElement;
      }
      element = element.parentElement;
    }
  }
  // Hàm thực hiện validate
  function validate(inputElement, rule) {
    var parentInputElement = getParentElement(
      inputElement,
      options.formGroupSelector
    );
    var errorElement = parentInputElement.querySelector(options.errorSelector);
    var errorMessage;

    // Lấy ra các rules của selector
    var rules = selectorRules[rule.selector];
    // Lặp qua và kiểm tra từng rule
    for (var i = 0; i < rules.length; i++) {
      switch (inputElement.type) {
        case "file":
          errorMessage = rules[i](inputElement.value);
          break;
        default:
          errorMessage = rules[i](inputElement.value);
      }
      if (errorMessage) break;
    }

    if (errorMessage) {
      parentInputElement.classList.add("invalid");
      errorElement.innerText = errorMessage;
    } else {
      parentInputElement.classList.remove("invalid");
      errorElement.innerText = "";
    }
    return !errorMessage;
  }

  var formElement = document.querySelector(options.form);
  if (formElement) {
    formElement.onsubmit = function (e) {
      e.preventDefault();
      var isFormValid = true;
      options.rules.forEach(function (rule) {
        var inputElement = formElement.querySelector(rule.selector);
        var isValid = validate(inputElement, rule);
        if (!isValid) {
          isFormValid = false;
        }
      });

      if (isFormValid) {
        // Trường hợp submit với JS
        if (typeof options.onSubmit === "function") {
          var enableInputs = formElement.querySelectorAll(
            "[name]:not([disabled])"
          );
          var formValues = Array.from(enableInputs).reduce(function (
            values,
            input
          ) {
            switch (input.type) {
              case "file":
              	values[input.name] = input.files;
              	break;
              default:
                values[input.name] = input.value;
            }
            return values;
          },
          {});

          options.onSubmit(formValues);
        }
        // Trường hợp submit với hành vi mặt định
        else {
          formElement.submit();
        }
      }
    };

    // Lặp qua mỗi rule và xử lí (onblur, oninput)
    options.rules.forEach(function (rule) {
      if (Array.isArray(selectorRules[rule.selector])) {
        selectorRules[rule.selector].push(rule.message);
      } else {
        selectorRules[rule.selector] = [rule.message];
      }

      var inputElements = formElement.querySelectorAll(rule.selector);
      Array.from(inputElements).forEach(function (inputElement) {
        // Xử lí sự kiện onblur khỏi input
        inputElement.onblur = function () {
          validate(inputElement, rule);
        };

        // Xử lí sự kiện oninput
        inputElement.oninput = function () {
          var parentInputElement = getParentElement(
            inputElement,
            options.formGroupSelector
          );
          var errorElement = parentInputElement.querySelector(
            options.errorSelector
          );
          errorElement.innerText = "";
          parentInputElement.classList.remove("invalid");
        };
      });
    });
  }
}

Validator.isRequired = function (selector, message) {
  return {
    selector: selector,
    message: function (value) {
      return value ? undefined : message;
    },
  };
};
