from behave import given, when, then, step

@given('we use behave')
def step_impl(context):
    pass

@when('we write specs')
def step_impl(context):
    assert True != False

@then('behave runs them')
def step_impl(context):
    assert context.failed is False
