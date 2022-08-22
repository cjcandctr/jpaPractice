
## Annotations:
- @Component
- @Repository
- @Service
- @Controller
- @Configuration
- @RequestMapping
- @Autowired
- @Bean
- @Scope
- @Conditional
- @Value("${smtp.host}")
- @SpringBootApplication

- @RequestParam
- @PathVariable
- @Entity
  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
- @SequenceGenerator(
  name="course_seq",
  sequenceName = "course_seq",
  allocationSize = 10
  )
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
  @Id
- @ManyToOne(
  cascade = CascadeType.PERSIST
  )
  @JoinColumn(
  name = "teacher_id_pk",
  referencedColumnName = "id"
  )
  protected Teacher teacher;

  @ManyToMany(
  cascade = CascadeType.PERSIST
  )
  @JoinTable(
  name="course_student",
  joinColumns = @JoinColumn(
  name = "course_id",
  referencedColumnName = "courseId"
  ),
  inverseJoinColumns = @JoinColumn(
  name="student_id",
  referencedColumnName = "id"
  )
  )
- @Modifying
  @Query(nativeQuery = true, value = "update student_tb set first_name=?1 where email_address=?2")
  @Transactional
- @RequestHeader("Keep-Alive")
- @CookieValue("foo")
- response.addCookie(new Cookie("heroku-nav-data", navData)); HttpHeaders responseHeaders = new HttpHeaders();

HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
Mockito.when(mockRequest.getPathInfo()).thenReturn("/enrollment/optout");
Whitebox.setInternalState(exceptionHandler, "request", mockRequest);
MockHttpServletRequest
AssertNotNull()