<%--
  Created by IntelliJ IDEA.
  User: ZAHIR
  Date: 03/16/2024
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 border-top" style="padding-left: 25px; padding-right: 25px">
    <div class="col-md-4 d-flex align-items-center">
        <a href="<%= request.getContextPath() %>" class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1">
            ZStore &nbsp;
        </a>
        <span class="mb-3 mb-md-0 text-body-secondary">&copy; 2024, Ismail ZAHIR</span>
    </div>

    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
        <li class="ms-3"><a class="text-body-secondary" href="https://github.com/ismailza">GitHub</a></li>
    </ul>
</footer>

<script>
    (() => {
        'use strict'
        const forms = document.querySelectorAll('.needs-validation')
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    })()
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
